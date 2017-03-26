package ru.iemz.adwords.auth;

import com.google.api.ads.adwords.lib.client.AdWordsSession;

/**
 * Created by Vladimir Aseev on 13.03.2017.
 *
 * Фабрика сессий для GoogleAdwords
 *
 */
public interface AdwordsSessionFactory {

    AdWordsSession getSession();
}
