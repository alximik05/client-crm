package ru.iemz.adwords.persistence.domains;

import javax.persistence.*;

/**
 * Created by Vladimir Aseev on 15.04.2017.
 *
 * Сущность для альфа-кампаний, автоматически созданных системой
 * данные кампании содержат ключевики и параметры ставок "для затравки"
 * в дальнейшем лучшие объявления отсюда переносятся в соответствующую
 * альфа-кампанию, а тут минусуются
 */
@Entity
@Table(name="CAMPAIGNS_ALPHA")
public class CampaignAlpha {

    @Id
    @Column(name = "CAMPAIGN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CLIENT_ID")
    private long externalClientId;

    @OneToOne
    @JoinColumn(name = "CAMPAIGN_ID")
    private CampaignBetta bettaCampaignId;

    @Column(name = "GOOGLE_CAMPAIGN_ID")
    private long googleCampaignId;





}
