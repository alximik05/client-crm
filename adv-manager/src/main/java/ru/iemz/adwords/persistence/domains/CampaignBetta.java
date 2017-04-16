package ru.iemz.adwords.persistence.domains;

import javax.persistence.*;

/**
 * Created by Vladimir Aseev on 13.03.2017.
 *
 * Сущность для бетта-кампаний, созданных пользователем
 * данные кампании содержат ключевики и параметры ставок "для затравки"
 * в дальнейшем лучшие объявления отсюда переносятся в соответствующую
 * альфа-кампанию, а тут минусуются
 */
@Entity
@Table(name="CAMPAIGNS_BETTA")
public class CampaignBetta {


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
    private CampaignAlpha alphaCampaignId;

    @Column(name = "GOOGLE_CAMPAIGN_ID")
    private long googleCampaignId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExternalClientId() {
        return externalClientId;
    }

    public void setExternalClientId(long externalClientId) {
        this.externalClientId = externalClientId;
    }

    public CampaignAlpha getAlphaCampaignId() {
        return alphaCampaignId;
    }

    public void setAlphaCampaignId(CampaignAlpha alphaCampaignId) {
        this.alphaCampaignId = alphaCampaignId;
    }

    public long getGoogleCampaignId() {
        return googleCampaignId;
    }

    public void setGoogleCampaignId(long googleCampaignId) {
        this.googleCampaignId = googleCampaignId;
    }
}
