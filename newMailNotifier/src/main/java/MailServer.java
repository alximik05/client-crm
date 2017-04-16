/**
 * Created by Vladimir Aseev on 15.04.2017.
 */
import org.subethamail.smtp.*;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.server.SMTPServer;

import javax.mail.*;
import javax.net.ssl.*;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Properties;
import java.util.Scanner;

public class MailServer {


    public static void main(String[] args) {

        //startServer("localhost", 587);
        startServerWithTLS("localhost", 587);

        blockUntilUserInput(" ");


    }

    private static void startServer(String host, int port){

        MessageHandlerFactory mhf = new MessageHandlerFactory() {
                    public MessageHandler create(final MessageContext messageContext) {
                        return new MessageHandler() {
                            public void from(String s) throws RejectException {
                                System.out.println("Пришло сообщение от: " + s);
                            }

                            public void recipient(String s) throws RejectException {
                                System.out.println("Пришло сообщение кому: " + s);
                            }

                            public void data(InputStream inputStream) throws RejectException, TooMuchDataException, IOException {
                                try{
                                    System.out.println("Попробуем что-нибудь прочитать...");

                                    Scanner sc = new Scanner(inputStream);
                                    while(sc.hasNextLine()){
                                        System.out.println(sc.nextLine());
                                    }

                                    System.out.println("Прочитали что-то " /*+ dis.readUTF()*/);
                                } catch (Exception e){
                                    System.out.println("Упс.. что-то сломалось: " + e.getMessage());
                                    e.printStackTrace(System.out);
                                }


                            }

                            public void done() {
                                System.out.println("Кто-то вызвал дан.");
                            }
                        };
                    }
                };

        SMTPServer smtpServer = new SMTPServer(mhf);

        smtpServer.setEnableTLS(true);

        smtpServer.setHostName(host);
        smtpServer.setPort(port);
        smtpServer.setRequireTLS(true);
        smtpServer.start();

    }

    private static void blockUntilUserInput(String stopMarker){
        System.out.println("Type " + stopMarker + " to stop...");
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            if(sc.hasNextLine()){
                if (sc.nextLine().equals(stopMarker)){
                    break;
                } else {
                    System.out.println("Incorrect input. Type "
                            + stopMarker + " to stop...");
                }
            }
        }

        System.out.println("Stopping...");
    }

    private static void startServerWithTLS(String host, int port){
        try{
            // Key store for your own private key and signing certificates.
            InputStream keyStoreIS = new FileInputStream("/path/to/keystore.p12");
            char[] keyStorePassphrase = "secret".toCharArray();
            KeyStore ksKeys = KeyStore.getInstance("PKCS12");
            ksKeys.load(keyStoreIS, keyStorePassphrase);

            //KeyManager decides which key material to use.
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ksKeys, keyStorePassphrase);

            // Trust store contains certificates of trusted certificate authorities.
            // We'll need this to do client authentication.
            InputStream trustStoreIS = new FileInputStream("/path/to/truststore.certs");
            char[] trustStorePassphrase = "secret".toCharArray();
            KeyStore ksTrust = KeyStore.getInstance("JKS");
            ksTrust.load(trustStoreIS, trustStorePassphrase);

            // TrustManager decides which certificate authorities to use.
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ksTrust);

            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            MessageHandlerFactory mhf = new MessageHandlerFactory() {
                public MessageHandler create(final MessageContext messageContext) {
                    return new MessageHandler() {
                        public void from(String s) throws RejectException {
                            System.out.println("Пришло сообщение от: " + s);
                        }

                        public void recipient(String s) throws RejectException {
                            System.out.println("Пришло сообщение кому: " + s);
                        }

                        public void data(InputStream inputStream) throws RejectException, TooMuchDataException, IOException {
                            try{
                                System.out.println("Попробуем что-нибудь прочитать...");

                                Scanner sc = new Scanner(inputStream);
                                while(sc.hasNextLine()){
                                    System.out.println(sc.nextLine());
                                }

                                System.out.println("Прочитали что-то " /*+ dis.readUTF()*/);
                            } catch (Exception e){
                                System.out.println("Упс.. что-то сломалось: " + e.getMessage());
                                e.printStackTrace(System.out);
                            }


                        }

                        public void done() {
                            System.out.println("Кто-то вызвал дан.");
                        }
                    };
                }
            };


            SMTPServer smtpServer = new SMTPServer(mhf) {
                @Override
                public SSLSocket createSSLSocket(Socket socket) throws IOException {
                    InetSocketAddress remoteAddress =
                            (InetSocketAddress) socket.getRemoteSocketAddress();

                    SSLSocketFactory sf = sslContext.getSocketFactory();
                    SSLSocket s = (SSLSocket) (sf.createSocket(
                            socket,
                            remoteAddress.getHostName(),
                            socket.getPort(),
                            true));

                    // we are a server
                    s.setUseClientMode(false);

                    // select strong protocols and cipher suites
  /*                  s.setEnabledProtocols(StrongSsl.intersection(
                            s.getSupportedProtocols(), StrongSsl.ENABLED_PROTOCOLS));
                    s.setEnabledCipherSuites(StrongSsl.intersection(
                            s.getSupportedCipherSuites(), StrongSsl.ENABLED_CIPHER_SUITES));
*/
                    //// Client must authenticate
                     s.setNeedClientAuth(false);

                    return s;
                }
            };

            smtpServer.setHostName(host);
            smtpServer.setPort(port);
            //smtpServer.setBindAddress(bindAddress);
            smtpServer.setRequireTLS(true);
            smtpServer.start();

        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }



    // Так можно получить почту
 /*   public static void main(String[] args) throws Exception {
        final String user = "el-radiance@bk.ru"; // имя пользователя
        final String pass = "***";    // пароль
        final String host = "imap.mail.ru";     // адрес почтового сервера

        // Создание свойств
        Properties props = new Properties();

        //включение debug-режима
        props.put("mail.debug", "true");

        //Указываем протокол - IMAP с SSL
        props.put("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props);
        Store store = session.getStore();

        //подключаемся к почтовому серверу
        store.connect(host, user, pass);

        //получаем папку с входящими сообщениями
        Folder inbox = store.getFolder("INBOX");

        //открываем её только для чтения
        inbox.open(Folder.READ_ONLY);

        //получаем последнее сообщение (самое старое будет под номером 1)
        Message m = inbox.getMessage(inbox.getMessageCount());
        Multipart mp = (Multipart) m.getContent();
        BodyPart bp = mp.getBodyPart(0);

        //Выводим содержимое на экран
        System.out.println(bp.getContent());
    }*/
}