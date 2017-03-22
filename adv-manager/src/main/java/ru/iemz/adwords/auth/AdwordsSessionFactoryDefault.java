package ru.iemz.adwords.auth;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.utils.v201702.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201702.cm.CampaignPage;
import com.google.api.ads.adwords.axis.v201702.cm.CampaignServiceInterface;
import com.google.api.ads.adwords.axis.v201702.cm.Selector;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.selectorfields.v201702.cm.CampaignField;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Vladimir Aseev on 13.03.2017.
 *
 * Фабрика сессий для подключения к Adwords, чтобы по всему коду не таскать
 * авторизационные данные и абстрагироваться от них
 */
public class AdwordsSessionFactoryDefault implements AdwordsSessionFactory {

    private static final Logger logger = LoggerFactory
            .getLogger(AdwordsSessionFactoryDefault.class);


    private final AdWordsSession session;


    public AdwordsSessionFactoryDefault(Credentials credentials){
        this.session = initializeSession(credentials);
    }


    public AdwordsSessionFactoryDefault(String credentialsFilename){
        this.session = initializeSession(credentialsFilename);
    }

    public AdwordsSessionFactoryDefault(){
        String pathToSecrets =
                Environment.getProperties().getProperty("secrets.file.path");
        if(pathToSecrets == null || pathToSecrets.equals("")){
            logger.error("secrets.file.path property must be set. " +
                    " Use VM flag -Dsecrets.file.path=\"<PATH_TO_CREDENTIALS_FILE>\" to set it.");
            System.exit(1);
        }
        logger.info("Searching authorization properties in file : {}", pathToSecrets);
        this.session = initializeSession(pathToSecrets);
    }




    private AdWordsSession initializeSession(String filePath){
        try{
            // Generate a refreshable OAuth2 credential.
            Credential oAuth2Credential = new OfflineCredentials.Builder()
                    .forApi(OfflineCredentials.Api.ADWORDS)
                    .fromFile(filePath)
                    .build()
                    .generateCredential();

            // Construct an AdWordsSession.
            //return
            AdWordsSession session = new AdWordsSession.Builder()
                    .fromFile(filePath)
                    .withOAuth2Credential(oAuth2Credential)
                    .build();

            checkAuth(session);

            return session;


        } catch (ValidationException e){
            logger.error("Google Adwords credentials validation exception : {}", e.getMessage());
            throw new Error("Google Adwords credentials validation exception", e);
        } catch (OAuthException e){
            logger.error("Google Adwords credential validation exception: {}", e.getMessage());
            throw new Error("Google Adwords credentials validation exception", e);
        } catch (Exception e){
            logger.error("Google Adwords auth check error : {} ", e.getMessage());
            throw new Error("Google Adwords auth check error", e);
        }
    }

    private AdWordsSession initializeSession(Credentials credentials){
        try{
            // Generate a refreshable OAuth2 credential.
            Credential oAuth2Credential = new OfflineCredentials.Builder()
                    .forApi(OfflineCredentials.Api.ADWORDS)
                    .withClientSecrets(credentials.getClientId(),
                            credentials.getClientSecret())
                    .withRefreshToken(credentials.getRefreshToken())
                    //.fromFile()
                    .build()
                    .generateCredential();

            // Construct an AdWordsSession.
            //return
            AdWordsSession session = new AdWordsSession.Builder()
                    .withClientCustomerId(credentials.getClientCustomerId())
                    .withDeveloperToken(credentials.getDeveloperToken())
                    //.fromFile()
                    .withOAuth2Credential(oAuth2Credential)
                    .build();

            checkAuth(session);

            return session;


        } catch (ValidationException e){
            logger.error("Google Adwords credentials validation exception : {}", e.getMessage());
            throw new Error("Google Adwords credentials validation exception", e);
        } catch (OAuthException e){
            logger.error("Google Adwords credential validation exception: {}", e.getMessage());
            throw new Error("Google Adwords credentials validation exception", e);
        } catch (Exception e){
            logger.error("Google Adwords auth check error : {} ", e.getMessage());
            throw new Error("Google Adwords auth check error", e);
        }
    }



    @Override
    public AdWordsSession getSession() {
        return session;
    }



    private void checkAuth(AdWordsSession session) throws Exception {
        AdWordsServicesInterface adWordsServices =
                AdWordsServices.getInstance();


        CampaignServiceInterface campaignServiceInterface =
                adWordsServices.get(session, CampaignServiceInterface.class);

        // Create selector.
        SelectorBuilder builder = new SelectorBuilder();
        int offset = 0;
        int pageSize = 1;
        Selector selector = builder
                .fields(CampaignField.Id, CampaignField.Name)
                .orderAscBy(CampaignField.Name)
                .offset(offset)
                .limit(pageSize)
                .build();

        CampaignPage campaignPage =
                campaignServiceInterface.get(selector);


    }
}
