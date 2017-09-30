package com.suis.logistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.suis.logistics.common.ConverterUtil;
import com.suis.logistics.common.DateUtil;
import com.suis.logistics.common.HibernateConfiguration;
import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.Client;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.model.TimeZone;
import com.suis.logistics.repository.client.ClientDao;
import com.suis.logistics.repository.common.RegionDao;
import com.suis.logistics.service.booking.BookingService;
import com.suis.logistics.service.cargo.CargoService;
import com.suis.logistics.service.container.ContainerService;
import com.suis.logistics.web.TimeZoneDto;

public class TestServiceAndDaoMain {

	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		// createContainer(context);
		// compareJavaTimeZonesWithDB();
		populateAllCitiesWithTimeZone();
		System.exit(0);

	}

	private static void populateAllCitiesWithTimeZone() {
	/*	RegionDao regionDao = (RegionDao) context.getBean("regionDaoImpl");
		List<City> cities = regionDao.getAllCitiesWithTimeZoneNull();
		Map<City, String> failedCities = new HashMap<>();
		int count = 1;
		for (City city : cities) {
			try {
				TimeZoneApiResponse response = new TimeZoneAPIintegrationMain()
						.getTimeZones(city.getState().getCountry().getCode(), city.getName());
				if (!response.getStatus().equalsIgnoreCase("FAILED")) {
					List<TimeZoneApiEntity> zones = response.getZones();
					if (zones != null && zones.size() > 1) {
						for (TimeZoneApiEntity zone : zones) {
							if (zone.getCountryCode().equals(city.getState().getCountry().getCode())
									&& zone.getRegionName().equalsIgnoreCase(city.getState().getName())) {
								city.setTimeZoneId(zone.getZoneName());
								city.setTimeZoneAbbereviation(zone.getAbbreviation());
								regionDao.updateCity(city);
								count++;
							}
						}
					} else if (zones != null && zones.size() == 1) {
						city.setTimeZoneId(zones.get(0).getZoneName());
						city.setTimeZoneAbbereviation(zones.get(0).getAbbreviation());
						regionDao.updateCity(city);
						count++;
					}
				}else {
					failedCities.put(city, "No Record Found in timezone API \n");
				}
			} catch (Exception e) {
				System.out
						.println("Failed updating City for city id :" + city.getId() + " and name : " + city.getName());
				e.printStackTrace();
				failedCities.put(city, e.getMessage()+"\n");
			}
		}
        System.out.println("Total no of records updated : "+count);
		System.out.println("Failed cities : "+failedCities);*/
	}

	public static void getBookingList() {
		BookingService service = (BookingService) context.getBean("bookingServiceImpl");
		System.out.println(service.getBookingList());
	}

	public static void clientEntityOperation() {
		ClientDao service = (ClientDao) context.getBean("clientDaoImpl");
		Client client = new Client();
		client.setName("A4");
		client.setCreatedDate(new Date());
		client.setUpdatedDate(new Date());
		service.createClient(client);
	}

	public static void createContainer() {
		ContainerService conServ = (ContainerService) context.getBean("containerServiceImpl");
		CargoService cargoServ = (CargoService) context.getBean("cargoServiceImpl");
		ContainerDetail containerDetail = new ContainerDetail();
		containerDetail.setContainerNo("CT-00005");
		List<Cargo> cargos = new ArrayList();
		cargos.add(cargoServ.getCargo(1));
		cargos.add(cargoServ.getCargo(2));
		containerDetail.setCargos(cargos);
		/*
		 * cg1.setContainerDetail(containerDetail);
		 * cg2.setContainerDetail(containerDetail);
		 * containerDetail.addCargo(cg1); containerDetail.addCargo(cg2);
		 */
		conServ.createContainer(containerDetail);
		System.out.println(containerDetail);
	}

	public static void compareJavaTimeZonesWithDB() {
		RegionDao regionDao = (RegionDao) context.getBean("regionDaoImpl");
		ConverterUtil c = (ConverterUtil) context.getBean("converterUtil");
		List<TimeZone> timezones = regionDao.getAllTimeZones();
		List<TimeZoneDto> alltzs = c.convertListTimeZoneToDto(timezones);
		DateUtil dateUtil = new DateUtil();
		List<TimeZoneDto> timeZoneDtoList = dateUtil.getAvailableTimeZones();
		List<String> missingTimeZoneIds = new ArrayList<>();
		for (TimeZoneDto tz : alltzs) {
			if (!timeZoneDtoList.contains(tz)) {
				missingTimeZoneIds.add(tz.getZoneId());
			}
		}
		System.out.println(missingTimeZoneIds);
	}
}
