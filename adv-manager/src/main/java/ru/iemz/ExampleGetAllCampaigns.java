package ru.iemz;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.utils.v201702.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201702.cm.Campaign;
import com.google.api.ads.adwords.axis.v201702.cm.CampaignPage;
import com.google.api.ads.adwords.axis.v201702.cm.CampaignServiceInterface;
import com.google.api.ads.adwords.axis.v201702.cm.Selector;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.selectorfields.v201702.cm.CampaignField;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.iemz.adwords.SpringContextStaticHolder;
import ru.iemz.adwords.auth.AdwordsSessionFactory;

@SpringBootApplication
public class ExampleGetAllCampaigns {

	private static final int PAGE_SIZE = 100;


	private static final AdwordsSessionFactory sessionFactory =
			SpringContextStaticHolder.getContext().getBean(AdwordsSessionFactory.class);




	public static void main(String[] args) throws Exception {


		AdWordsSession session = sessionFactory.getSession();

		AdWordsServicesInterface adWordsServices = AdWordsServices.getInstance();

		runExample(adWordsServices, session);
	}

	public static void runExample(
			AdWordsServicesInterface adWordsServices, AdWordsSession session) throws Exception {
		// Get the CampaignService.
		CampaignServiceInterface campaignService =
				adWordsServices.get(session, CampaignServiceInterface.class);

		int offset = 0;

		// Create selector.
		SelectorBuilder builder = new SelectorBuilder();
		Selector selector = builder
				.fields(CampaignField.Id, CampaignField.Name)
				.orderAscBy(CampaignField.Name)
				.offset(offset)
				.limit(PAGE_SIZE)
				.build();

		CampaignPage page = null;
		do {
			// Get all campaigns.
			page = campaignService.get(selector);

			// Display campaigns.
			if (page.getEntries() != null) {
				for (Campaign campaign : page.getEntries()) {
					System.out.printf("Campaign with name '%s' and ID %d was found.%n", campaign.getName(),
							campaign.getId());
					System.out.println("ID: " + campaign.getId());
				}
			} else {
				System.out.println("No campaigns were found.");
			}

			offset += PAGE_SIZE;
			selector = builder.increaseOffsetBy(PAGE_SIZE).build();
		} while (offset < page.getTotalNumEntries());
	}





}
