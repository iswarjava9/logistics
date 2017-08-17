CREATE TABLE `booking_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `nvocc_booking_no` varchar(25) DEFAULT NULL,
  `division_id` int(11) DEFAULT NULL,
  `line_of_business_id` int(11) DEFAULT NULL,
  `sales_representative_id` int(11) DEFAULT NULL,
  `controller` varchar(10) DEFAULT NULL,
  `shipper_ref_no` varchar(25) DEFAULT NULL,
  `forwarder_ref_no` varchar(25) DEFAULT NULL,
  `carrier_booking_no` varchar(25) DEFAULT NULL,
  `aes_auth_no` varchar(25) DEFAULT NULL,
  `booking_status_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `shipper_id` int(11) DEFAULT NULL,
  `consignee_id` int(11) DEFAULT NULL,
  `notify_id` int(11) DEFAULT NULL,
  `forwarder_id` int(11) DEFAULT NULL COMMENT 'This filed refers to client table,as forwarder is a cleint for the application.',
  `booking_person_id` int(11) DEFAULT NULL,
  `carrier_id` int(11) DEFAULT NULL,
  `carrier_contact` varchar(100) DEFAULT NULL,
  `service_contract_id` int(11) DEFAULT NULL,
  `carrier_voyage` varchar(25) DEFAULT NULL,
  `vessel_id` int(11) DEFAULT NULL,
  `nra_number` varchar(20) DEFAULT NULL,
  `type_of_move_id` int(11) DEFAULT NULL,
  `type_of_service_id` int(11) DEFAULT NULL,
  `local_ss_line_office_id` int(11) DEFAULT NULL,
  `load_terminal_id` int(11) DEFAULT NULL,
  `place_of_receipt_id` int(11) DEFAULT NULL,
  `port_of_load_id` int(11) DEFAULT NULL,
  `port_of_discharge_id` int(11) DEFAULT NULL,
  `place_of_delivery_id` int(11) DEFAULT NULL,
  `transhipment_port_id` int(11) DEFAULT NULL,
  `foreign_agent_id` int(11) DEFAULT NULL,
  `booking_date` datetime DEFAULT NULL,
  `cut_off_date` datetime DEFAULT NULL,
  `cargo_moving_date` datetime DEFAULT NULL,
  `sail_date` datetime DEFAULT NULL,
  `eta` datetime DEFAULT NULL,
  `delievery_eta` datetime DEFAULT NULL,
  `freight` varchar(20) DEFAULT NULL COMMENT 'The value of this column can be "Prepaid" or "Collect".',
  `docs_received_date` datetime DEFAULT NULL,
  `rate_cut_off_date_time` datetime DEFAULT NULL,
  `docs_cut_off_date_time` datetime DEFAULT NULL,
  `container_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_detail__idx` (`id`),
  KEY `booking_detail__idxv1` (`nvocc_booking_no`),
  KEY `booking_detail__idxv2` (`forwarder_ref_no`),
  KEY `booking_detail__idxv3` (`shipper_ref_no`),
  KEY `booking_detail__idxv4` (`carrier_booking_no`),
  KEY `booking_container1_FK` (`container_id`),
  KEY `client_fk` (`client_id`),
  KEY `customer__foreign_agent_fk` (`foreign_agent_id`),
  KEY `customer_account_fk` (`account_id`),
  KEY `customer_consignee_fk` (`consignee_id`),
  KEY `customer_local_ss_line_fk` (`local_ss_line_office_id`),
  KEY `customer_notify_fk` (`notify_id`),
  KEY `customer_shipper_fk` (`shipper_id`),
  KEY `physical_entity_load_terminal_fk` (`load_terminal_id`),
  KEY `physical_entity_place_of_del_fk` (`place_of_delivery_id`),
  KEY `physical_entity_place_of_receipt_fk` (`place_of_receipt_id`),
  KEY `physical_entity_port_of_dis_fk` (`port_of_discharge_id`),
  KEY `physical_entity_port_of_load_fk` (`port_of_load_id`),
  KEY `physical_entity_transhipment_port_fk` (`transhipment_port_id`),
  KEY `booking_user1_FK` (`user_id`),
  CONSTRAINT `booking_container1_FK` FOREIGN KEY (`container_id`) REFERENCES `container_detail` (`id`),
  CONSTRAINT `booking_user1_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `customer__foreign_agent_fk` FOREIGN KEY (`foreign_agent_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_account_fk` FOREIGN KEY (`account_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_consignee_fk` FOREIGN KEY (`consignee_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_local_ss_line_fk` FOREIGN KEY (`local_ss_line_office_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_notify_fk` FOREIGN KEY (`notify_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_shipper_fk` FOREIGN KEY (`shipper_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `physical_entity_load_terminal_fk` FOREIGN KEY (`load_terminal_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_place_of_del_fk` FOREIGN KEY (`place_of_delivery_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_place_of_receipt_fk` FOREIGN KEY (`place_of_receipt_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_port_of_dis_fk` FOREIGN KEY (`port_of_discharge_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_port_of_load_fk` FOREIGN KEY (`port_of_load_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_transhipment_port_fk` FOREIGN KEY (`transhipment_port_id`) REFERENCES `place` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

CREATE TABLE `business_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `line_of_business` int(11) DEFAULT NULL,
  `description` varchar(25) DEFAULT NULL,
  `transport_mode` varchar(20) DEFAULT NULL,
  `transport_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_template_id` int(11) DEFAULT NULL COMMENT 'used as field name description in UI.',
  `schedule_b_id` int(11) DEFAULT NULL,
  `hts_id` int(11) DEFAULT NULL,
  `no_of_pieces` int(11) DEFAULT NULL,
  `piece_type_id` int(11) DEFAULT NULL,
  `gross_lbs` varchar(20) DEFAULT NULL,
  `gross_kgs` varchar(20) DEFAULT NULL,
  `gross_cft` varchar(20) DEFAULT NULL,
  `gross_cbm` varchar(20) DEFAULT NULL,
  `net_lbs` varchar(20) DEFAULT NULL,
  `net_kgs` varchar(20) DEFAULT NULL,
  `net_cft` varchar(20) DEFAULT NULL,
  `net_cbm` varchar(20) DEFAULT NULL,
  `cartoons` int(11) DEFAULT NULL,
  `cartoon_length` double DEFAULT NULL,
  `cartoon_width` double DEFAULT NULL,
  `cartoon_hieght` double DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `contents_description` varchar(100) DEFAULT NULL,
  `container_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `piece_type_FK` (`piece_type_id`),
  KEY `container_FK` (`container_id`),
  KEY `cargo_template_FK` (`cargo_template_id`),
  KEY `commodity1_FK` (`schedule_b_id`),
  CONSTRAINT `cargo_template_FK` FOREIGN KEY (`cargo_template_id`) REFERENCES `cargo_template` (`id`),
  CONSTRAINT `commodity1_FK` FOREIGN KEY (`schedule_b_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `cargo_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_type_code` varchar(20) DEFAULT NULL,
  `schedule_b_id` int(11) DEFAULT NULL,
  `hts_id` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `commodity2_FK` (`schedule_b_id`),
  CONSTRAINT `commodity2_FK` FOREIGN KEY (`schedule_b_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `country_code` varchar(20) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `updateddate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client__idx` (`id`),
  KEY `client__idxv1` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_b` varchar(20) DEFAULT NULL,
  `commodity` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `primary_quantity` varchar(20) DEFAULT NULL,
  `secondary_quantity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `container_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `container_no` varchar(20) DEFAULT NULL,
  `container_type_id` int(11) DEFAULT NULL,
  `seal1` varchar(20) DEFAULT NULL,
  `seal2` varchar(20) DEFAULT NULL,
  `seal3` varchar(20) DEFAULT NULL,
  `tare_lbs` double DEFAULT NULL,
  `tare_kgs` double DEFAULT NULL,
  `gross_lbs` double DEFAULT NULL,
  `gross_kgs` double DEFAULT NULL,
  `equipment` varchar(20) DEFAULT NULL,
  `booking_id` int(11) DEFAULT NULL,
  `quotation_id` int(11) DEFAULT NULL,
  `vehicle_no` int(20) DEFAULT NULL,
  `stuffing_no` int(20) DEFAULT NULL,
  `railway_bill_no` int(20) DEFAULT NULL,
  `planned_ship_date` datetime DEFAULT NULL,
  `discharge_date` datetime DEFAULT NULL,
  `pickup_date` datetime DEFAULT NULL,
  `cus_pickup_last_free_date` datetime DEFAULT NULL,
  `cus_return_last_free_date` datetime DEFAULT NULL,
  `car_pickup_last_free_date` datetime DEFAULT NULL,
  `car_return_last_free_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY ` quotation_FK` (`quotation_id`),
  KEY `booking_container_FK` (`booking_id`),
  KEY `container_type_FK` (`container_type_id`),
  CONSTRAINT ` quotation_FK` FOREIGN KEY (`quotation_id`) REFERENCES `quotation` (`id`),
  CONSTRAINT `booking_container_FK` FOREIGN KEY (`booking_id`) REFERENCES `booking_detail` (`id`),
  CONSTRAINT `container_type_FK` FOREIGN KEY (`container_type_id`) REFERENCES `container_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

CREATE TABLE `container_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `container_type` varchar(20) DEFAULT NULL,
  `iso_code` varchar(20) DEFAULT NULL,
  `teu` double DEFAULT NULL,
  `cbm` double DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `descirption` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `country` (
  `id` int(11) NOT NULL DEFAULT '0',
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  `street` varchar(100) DEFAULT NULL,
  `ams2_ops_controller` varchar(25) DEFAULT NULL COMMENT 'Basically the controller is the person doing the booking from KBS/LI.',
  `state_code` varchar(25) DEFAULT NULL,
  `country_code` varchar(25) DEFAULT NULL,
  `zip_code` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `contact_id` int(11) NOT NULL,
  `industry_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer__idx` (`id`),
  KEY `customer__idxv1` (`client_id`),
  KEY `customer_person_fk` (`contact_id`),
  CONSTRAINT `customer_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `customer_person_fk` FOREIGN KEY (`contact_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `division` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `branch_address` varchar(100) DEFAULT NULL,
  `code` varchar(25) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `division__idx` (`id`),
  KEY `division_client_fk` (`client_id`),
  CONSTRAINT `division_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `inco_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inco_term` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `movement_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_service` varchar(20) DEFAULT NULL,
  `edi_code` varchar(20) DEFAULT NULL,
  `moves_start` varchar(20) DEFAULT NULL,
  `moves_end` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `mobile` varchar(25) DEFAULT NULL,
  `fax` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `person__idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `piece_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `piece_type` varchar(20) DEFAULT NULL,
  `edi_code1` varchar(20) DEFAULT NULL,
  `edi_code2` varchar(20) DEFAULT NULL,
  `handheld_scanner` tinyint(1) DEFAULT NULL,
  `bulk_item` tinyint(1) DEFAULT NULL,
  `inactive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `code` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `country_code` varchar(10) DEFAULT NULL,
  `port_state_code` varchar(10) DEFAULT NULL COMMENT 'This column refers to state of a country and only applicable for US.',
  `un_code` varchar(10) DEFAULT NULL,
  `brokerage_rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `physical_entity__idx` (`id`),
  KEY `physical_entity__idxv1` (`type_id`),
  KEY `physical_entity__idxv2` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE `quotation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `contact_id` int(11) DEFAULT NULL,
  `customer_ref_no` varchar(20) DEFAULT NULL,
  `pickup_city_id` int(11) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `port_of_load_id` int(11) DEFAULT NULL,
  `port_of_discharge_id` int(11) DEFAULT NULL,
  `final_destination_id` int(11) DEFAULT NULL,
  `type_of_movement_id` int(11) DEFAULT NULL,
  `quote_no` varchar(20) DEFAULT NULL,
  `division_id` int(11) DEFAULT NULL,
  `business_line_id` int(11) DEFAULT NULL,
  `inco_term_id` int(11) DEFAULT NULL,
  `inco_term_location` varchar(25) DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `quoted_by` varchar(20) DEFAULT NULL,
  `sales_representative_id` int(11) DEFAULT NULL,
  `preferred_carrier_id` int(11) DEFAULT NULL,
  `voyage` varchar(20) DEFAULT NULL,
  `vessel_id` int(11) DEFAULT NULL,
  `container_handling` varchar(20) DEFAULT NULL,
  `payment_term` varchar(20) DEFAULT NULL,
  `service_type_id` int(11) DEFAULT NULL,
  `service_level_id` int(11) DEFAULT NULL,
  `transit_time` varchar(20) DEFAULT NULL,
  `agent_driven` tinyint(1) DEFAULT NULL,
  `container_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `business_line_FK` (`business_line_id`),
  KEY `contact_FK` (`contact_id`),
  KEY `customer_FK` (`customer_id`),
  KEY `division_FK` (`division_id`),
  KEY `final_destination_FK` (`final_destination_id`),
  KEY `incoterm_FK` (`inco_term_id`),
  KEY `movement_type_FK` (`type_of_movement_id`),
  KEY `pickup_city_FK` (`pickup_city_id`),
  KEY `port_of_discharge_FK` (`port_of_discharge_id`),
  KEY `port_of_load_FK` (`port_of_load_id`),
  KEY `preferred_carrier_FK` (`preferred_carrier_id`),
  KEY `quotation_country_FK` (`country_id`),
  KEY `sales_representative_FK` (`sales_representative_id`),
  KEY `service_level_FK` (`service_level_id`),
  KEY `service_type_FK` (`service_type_id`),
  KEY `state_FK` (`state_id`),
  KEY `vessel_FK` (`vessel_id`),
  KEY `container_FK` (`container_id`),
  CONSTRAINT `business_line_FK` FOREIGN KEY (`business_line_id`) REFERENCES `business_line` (`id`),
  CONSTRAINT `contact_FK` FOREIGN KEY (`contact_id`) REFERENCES `person` (`id`),
  CONSTRAINT `container_FK` FOREIGN KEY (`container_id`) REFERENCES `container_detail` (`id`),
  CONSTRAINT `customer_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `division_FK` FOREIGN KEY (`division_id`) REFERENCES `division` (`id`),
  CONSTRAINT `final_destination_FK` FOREIGN KEY (`final_destination_id`) REFERENCES `place` (`id`),
  CONSTRAINT `incoterm_FK` FOREIGN KEY (`inco_term_id`) REFERENCES `inco_term` (`id`),
  CONSTRAINT `movement_type_FK` FOREIGN KEY (`type_of_movement_id`) REFERENCES `movement_type` (`id`),
  CONSTRAINT `pickup_city_FK` FOREIGN KEY (`pickup_city_id`) REFERENCES `place` (`id`),
  CONSTRAINT `port_of_discharge_FK` FOREIGN KEY (`port_of_discharge_id`) REFERENCES `place` (`id`),
  CONSTRAINT `port_of_load_FK` FOREIGN KEY (`port_of_load_id`) REFERENCES `place` (`id`),
  CONSTRAINT `preferred_carrier_FK` FOREIGN KEY (`preferred_carrier_id`) REFERENCES `place` (`id`),
  CONSTRAINT `quotation_country_FK` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `sales_representative_FK` FOREIGN KEY (`sales_representative_id`) REFERENCES `person` (`id`),
  CONSTRAINT `service_level_FK` FOREIGN KEY (`service_level_id`) REFERENCES `service_level` (`id`),
  CONSTRAINT `service_type_FK` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`),
  CONSTRAINT `state_FK` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`),
  CONSTRAINT `vessel_FK` FOREIGN KEY (`vessel_id`) REFERENCES `vessel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `service_level` (
  `id` int(11) NOT NULL DEFAULT '0',
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `service_type` (
  `id` int(11) NOT NULL DEFAULT '0',
  `type` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `state` (
  `id` int(11) NOT NULL DEFAULT '0',
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_FK` (`country_id`),
  CONSTRAINT `country_FK` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `temporary` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `datewithtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `staus` varchar(20) DEFAULT NULL,
  `email_id` varchar(25) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user__idx` (`id`),
  KEY `user_client_fk` (`client_id`),
  CONSTRAINT `user_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `vessel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vessel_no` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `flag_id` int(11) DEFAULT NULL,
  `lloyds _code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flag_country_FK` (`flag_id`),
  CONSTRAINT `flag_country_FK` FOREIGN KEY (`flag_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

