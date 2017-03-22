package ru.iemz.adwords.campaignBuilder;

import ru.iemz.adwords.auth.AdwordsSessionFactory;

/**
 * Created by Vladimir Aseev on 13.03.2017.
 *
 * Данный класс предназначен для создания кампаний класса "бета".
 *
 * Это рекламные кампании, созданные на основе ключевиков, заданных пользователем
 * и предварительных (начальных) минус-слов и ставок. При создании кампании "бета"
 * одновременно будет создана пустая кампания "альфа" и ассоциирована с первой.
 * В процессе накопления статистики по кампаниям "бета" хорошо работающие объявления
 * и фразы из будут переноситься в кампании "альфа" и цены по ним будут повышаться.
 *
 */
public class BuilderBetta {


    private final AdwordsSessionFactory sessionFactory;

    public BuilderBetta(AdwordsSessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }




}
