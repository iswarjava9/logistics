SET FOREIGN_KEY_CHECKS = 0;
CREATE TABLE `bill_of_lading` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipper` varchar(50) DEFAULT NULL,
  `carrier_ref_no` varchar(50) DEFAULT NULL,
  `bl_no` varchar(50) DEFAULT NULL,
  `cosolidation_no` varchar(50) DEFAULT NULL,
  `consignee` varchar(50) DEFAULT NULL,
  `export_reference` varchar(50) DEFAULT NULL,
  `mbl_no` varchar(50) DEFAULT NULL,
  `shipper_ref` varchar(50) DEFAULT NULL,
  `forwarding_agent` varchar(50) DEFAULT NULL,
  `ftz_no` varchar(50) DEFAULT NULL,
  `notify` varchar(50) DEFAULT NULL,
  `delievery_agent` varchar(50) DEFAULT NULL,
  `precarriage_by` varchar(50) DEFAULT NULL,
  `place_of_receipt` varchar(50) DEFAULT NULL,
  `vessel_voyage` varchar(50) DEFAULT NULL,
  `port_of_load` varchar(50) DEFAULT NULL,
  `ingate_at_terminal` varchar(50) DEFAULT NULL,
  `port_of_discharge` varchar(50) DEFAULT NULL,
  `place_of_delivery` varchar(50) DEFAULT NULL,
  `coloaded_with` varchar(50) DEFAULT NULL,
  `cargo_description` varchar(500) DEFAULT NULL,
  `booking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bl_to_booking_fk` (`booking_id`),
  CONSTRAINT `bl_to_booking_fk` FOREIGN KEY (`booking_id`) REFERENCES `booking_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

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
  `booking_status` varchar(20) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `shipper_id` int(11) DEFAULT NULL,
  `consignee_id` int(11) DEFAULT NULL,
  `notify1_id` int(11) DEFAULT NULL,
  `forwarder_id` int(11) DEFAULT NULL COMMENT 'This filed refers to client table,as forwarder is a cleint for the application.',
  `booking_person_id` int(11) DEFAULT NULL,
  `carrier_id` int(11) DEFAULT NULL,
  `carrier_contact` varchar(100) DEFAULT NULL,
  `service_contract_id` int(11) DEFAULT NULL,
  `carrier_voyage` varchar(25) DEFAULT NULL,
  `vessel_id` int(11) DEFAULT NULL,
  `nra_number` varchar(20) DEFAULT NULL,
  `type_of_move_id` int(11) DEFAULT NULL,
  `type_of_service` varchar(20) DEFAULT NULL,
  `local_ss_line_office_id` int(11) DEFAULT NULL,
  `load_terminal_id` int(11) DEFAULT NULL,
  `place_of_receipt_id` int(11) DEFAULT NULL,
  `port_of_load_id` int(11) DEFAULT NULL,
  `port_of_discharge_id` int(11) DEFAULT NULL,
  `place_of_delivery_id` int(11) DEFAULT NULL,
  `transhipment_port_id` int(11) DEFAULT NULL,
  `delivery_agent_id` int(11) DEFAULT NULL,
  `booking_date` datetime DEFAULT NULL,
  `cut_off_date` datetime DEFAULT NULL,
  `cargo_moving_date` datetime DEFAULT NULL,
  `sail_date` datetime DEFAULT NULL,
  `eta` datetime DEFAULT NULL,
  `delievery_eta` datetime DEFAULT NULL,
  `freight` varchar(20) DEFAULT NULL COMMENT 'The value of this column can be "Prepaid" or "Collect".',
  `docs_received_date` datetime DEFAULT NULL,
  `rail_cut_off_date_time` datetime DEFAULT NULL,
  `docs_cut_off_date_time` datetime DEFAULT NULL,
  `remarks` varchar(5000) DEFAULT NULL,
  `booking_agent_id` int(11) DEFAULT NULL,
  `amendment_date` datetime DEFAULT NULL,
  `notify2_id` int(11) DEFAULT NULL,
  `ingate_terminal_id` int(11) DEFAULT NULL,
  `empty_pickup_date` datetime DEFAULT NULL,
  `early_receiving_date` datetime DEFAULT NULL,
  `cargo_supplier_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_detail__idx` (`id`),
  KEY `booking_detail__idxv1` (`nvocc_booking_no`),
  KEY `booking_detail__idxv2` (`forwarder_ref_no`),
  KEY `booking_detail__idxv3` (`shipper_ref_no`),
  KEY `booking_detail__idxv4` (`carrier_booking_no`),
  KEY `booking_agent_customer_FK` (`booking_agent_id`),
  KEY `booking_carrier_FK` (`carrier_id`),
  KEY `booking_user1_FK` (`user_id`),
  KEY `cargosupplier_to_customer_FK` (`cargo_supplier_id`),
  KEY `client_fk` (`client_id`),
  KEY `customer__foreign_agent_fk` (`delivery_agent_id`),
  KEY `customer_account_fk` (`account_id`),
  KEY `customer_consignee_fk` (`consignee_id`),
  KEY `customer_local_ss_line_fk` (`local_ss_line_office_id`),
  KEY `customer_notify_fk` (`notify1_id`),
  KEY `customer_shipper_fk` (`shipper_id`),
  KEY `ingate_terminal_place_FK` (`ingate_terminal_id`),
  KEY `notify2_customer_FK` (`notify2_id`),
  KEY `physical_entity_load_terminal_fk` (`load_terminal_id`),
  KEY `physical_entity_place_of_del_fk` (`place_of_delivery_id`),
  KEY `physical_entity_place_of_receipt_fk` (`place_of_receipt_id`),
  KEY `physical_entity_port_of_dis_fk` (`port_of_discharge_id`),
  KEY `physical_entity_port_of_load_fk` (`port_of_load_id`),
  KEY `physical_entity_transhipment_port_fk` (`transhipment_port_id`),
  CONSTRAINT `booking_agent_customer_FK` FOREIGN KEY (`booking_agent_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `booking_carrier_to_cutomer_FK` FOREIGN KEY (`carrier_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `booking_user1_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `cargosupplier_to_customer_FK` FOREIGN KEY (`cargo_supplier_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `customer__foreign_agent_fk` FOREIGN KEY (`delivery_agent_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_account_fk` FOREIGN KEY (`account_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_consignee_fk` FOREIGN KEY (`consignee_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_local_ss_line_fk` FOREIGN KEY (`local_ss_line_office_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_notify_fk` FOREIGN KEY (`notify1_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `customer_shipper_fk` FOREIGN KEY (`shipper_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `ingate_terminal_place_FK` FOREIGN KEY (`ingate_terminal_id`) REFERENCES `place` (`id`),
  CONSTRAINT `notify2_customer_FK` FOREIGN KEY (`notify2_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `physical_entity_load_terminal_fk` FOREIGN KEY (`load_terminal_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_place_of_del_fk` FOREIGN KEY (`place_of_delivery_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_place_of_receipt_fk` FOREIGN KEY (`place_of_receipt_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_port_of_dis_fk` FOREIGN KEY (`port_of_discharge_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_port_of_load_fk` FOREIGN KEY (`port_of_load_id`) REFERENCES `place` (`id`),
  CONSTRAINT `physical_entity_transhipment_port_fk` FOREIGN KEY (`transhipment_port_id`) REFERENCES `place` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

CREATE TABLE `business_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `line_of_business` int(11) DEFAULT NULL,
  `description` varchar(25) DEFAULT NULL,
  `transport_mode` varchar(20) DEFAULT NULL,
  `transport_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `container_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `piece_type_FK` (`piece_type_id`),
  KEY `container_FK` (`container_id`),
  KEY `cargo_template_FK` (`cargo_template_id`),
  KEY `commodity1_FK` (`schedule_b_id`),
  CONSTRAINT `cargo_template_FK` FOREIGN KEY (`cargo_template_id`) REFERENCES `cargo_template` (`id`),
  CONSTRAINT `commodity1_FK` FOREIGN KEY (`schedule_b_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cargo_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_type_code` varchar(20) DEFAULT NULL,
  `schedule_b_id` int(11) DEFAULT NULL,
  `hts_id` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `commodity2_FK` (`schedule_b_id`),
  CONSTRAINT `commodity2_FK` FOREIGN KEY (`schedule_b_id`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `timezone_id` varchar(50) DEFAULT NULL,
  `timezone_abbreviation` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `state_id_FK` (`state_id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `primary_quantity` varchar(20) DEFAULT NULL,
  `secondary_quantity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
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
  `booking_id` int(11) NOT NULL,
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
  `commodity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY ` quotation_FK` (`quotation_id`),
  KEY `booking_container_FK` (`booking_id`),
  KEY `container_to_commodity_FK` (`commodity_id`),
  KEY `container_type_FK` (`container_type_id`),
  CONSTRAINT ` quotation_FK` FOREIGN KEY (`quotation_id`) REFERENCES `quotation` (`id`),
  CONSTRAINT `booking_container_FK` FOREIGN KEY (`booking_id`) REFERENCES `booking_detail` (`id`),
  CONSTRAINT `container_to_commodity_FK` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`id`),
  CONSTRAINT `container_type_FK` FOREIGN KEY (`container_type_id`) REFERENCES `container_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

CREATE TABLE `container_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `container_type` varchar(20) DEFAULT NULL,
  `iso_code` varchar(20) DEFAULT NULL,
  `teu` double DEFAULT NULL,
  `cbm` double DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `descirption` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `country` (
  `id` int(11) NOT NULL DEFAULT '0',
  `code` varchar(4) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `phonecode` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `custom_fields_mapping` (
  `id` int(11) DEFAULT NULL,
  `zoho_custom_field_id` bigint(20) DEFAULT NULL,
  `field_name` varchar(59) DEFAULT NULL,
  `mapped_field_name` varchar(50) DEFAULT NULL,
  `data_type` varchar(50) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  `show_in_all_pdf` varchar(50) DEFAULT NULL,
  `show_on_pdf` varchar(50) DEFAULT NULL,
  `index` int(11) DEFAULT NULL,
  `label` varchar(59) DEFAULT NULL,
  `placeholder` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  `personincharge` varchar(50) DEFAULT NULL COMMENT 'Basically the controller is the person doing the booking from KBS/LI.',
  `zip_code` varchar(25) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `phone_no` varchar(20) DEFAULT NULL,
  `tax_id` varchar(25) DEFAULT NULL,
  `tp_customer_id` varchar(50) DEFAULT NULL COMMENT 'This customer Id is used to represent the customer created in thirdparty system.',
  PRIMARY KEY (`id`),
  KEY `customer__idx` (`id`),
  KEY `customer__idxv1` (`client_id`),
  KEY `customer_name_index` (`name`) USING BTREE,
  KEY `customer_to_city_FK` (`city_id`),
  CONSTRAINT `customer_to_city_FK` FOREIGN KEY (`city_id`) REFERENCES `m_city_state_country` (`id`),
  CONSTRAINT `customer_to_client_FK` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `inco_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inco_term` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `m_city` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `state_id` int(11) unsigned NOT NULL,
  `country_id` smallint(5) unsigned NOT NULL,
  `latitude` decimal(10,8) NOT NULL,
  `longitude` decimal(11,8) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_region_name` (`country_id`,`state_id`,`name`),
  KEY `m_city_to_m_state_FK` (`state_id`),
  CONSTRAINT `m_city_to_m_state_FK` FOREIGN KEY (`state_id`) REFERENCES `m_state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `m_city_state_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_iso_code` varchar(20) DEFAULT NULL,
  `country_name` varchar(100) DEFAULT NULL,
  `state_iso_code` varchar(20) DEFAULT NULL,
  `state_name` varchar(100) DEFAULT NULL,
  `subdivision_2_name` varchar(100) DEFAULT NULL,
  `city_name` varchar(100) DEFAULT NULL,
  `time_zone` varchar(100) DEFAULT NULL,
  `timezone_abbereviation` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96476 DEFAULT CHARSET=latin1;

CREATE TABLE `m_country` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `m_state` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  `country_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_name` (`country_id`,`name`),
  CONSTRAINT `m_state_to_m_country_FK` FOREIGN KEY (`country_id`) REFERENCES `m_country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

CREATE TABLE `movement_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_service` varchar(20) DEFAULT NULL,
  `edi_code` varchar(20) DEFAULT NULL,
  `moves_start` varchar(20) DEFAULT NULL,
  `moves_end` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `mobile` varchar(25) DEFAULT NULL,
  `fax` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `person__idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `piece_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `piece_type` varchar(20) DEFAULT NULL,
  `edi_code1` varchar(20) DEFAULT NULL,
  `edi_code2` varchar(20) DEFAULT NULL,
  `handheld_scanner` tinyint(1) DEFAULT NULL,
  `bulk_item` tinyint(1) DEFAULT NULL,
  `inactive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(25) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `timezone_id` varchar(50) DEFAULT NULL,
  `timezone_shortname` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `physical_entity__idx` (`id`),
  KEY `physical_entity__idxv2` (`code`),
  KEY `index_name` (`name`) USING BTREE,
  KEY `place_to_city_FK` (`city_id`),
  CONSTRAINT `place_to_city_FK` FOREIGN KEY (`city_id`) REFERENCES `m_city_state_country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `place_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(25) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `timezone_id` varchar(50) DEFAULT NULL,
  `timezone_shortname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `place_copy_to_city_FK` (`city_id`),
  CONSTRAINT `place_copy_to_city_FK` FOREIGN KEY (`city_id`) REFERENCES `m_city_state_country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  KEY `state_FK` (`state_id`),
  KEY `quotation_country_FK` (`country_id`),
  KEY `container_FK` (`container_id`),
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
  KEY `sales_representative_FK` (`sales_representative_id`),
  KEY `service_level_FK` (`service_level_id`),
  KEY `service_type_FK` (`service_type_id`),
  KEY `vessel_FK` (`vessel_id`),
  CONSTRAINT `business_line_FK` FOREIGN KEY (`business_line_id`) REFERENCES `business_line` (`id`),
  CONSTRAINT `contact_FK` FOREIGN KEY (`contact_id`) REFERENCES `person` (`id`),
  CONSTRAINT `customer_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `division_FK` FOREIGN KEY (`division_id`) REFERENCES `division` (`id`),
  CONSTRAINT `final_destination_FK` FOREIGN KEY (`final_destination_id`) REFERENCES `place` (`id`),
  CONSTRAINT `incoterm_FK` FOREIGN KEY (`inco_term_id`) REFERENCES `inco_term` (`id`),
  CONSTRAINT `movement_type_FK` FOREIGN KEY (`type_of_movement_id`) REFERENCES `movement_type` (`id`),
  CONSTRAINT `pickup_city_FK` FOREIGN KEY (`pickup_city_id`) REFERENCES `place` (`id`),
  CONSTRAINT `port_of_discharge_FK` FOREIGN KEY (`port_of_discharge_id`) REFERENCES `place` (`id`),
  CONSTRAINT `port_of_load_FK` FOREIGN KEY (`port_of_load_id`) REFERENCES `place` (`id`),
  CONSTRAINT `preferred_carrier_FK` FOREIGN KEY (`preferred_carrier_id`) REFERENCES `place` (`id`),
  CONSTRAINT `sales_representative_FK` FOREIGN KEY (`sales_representative_id`) REFERENCES `person` (`id`),
  CONSTRAINT `service_level_FK` FOREIGN KEY (`service_level_id`) REFERENCES `service_level` (`id`),
  CONSTRAINT `service_type_FK` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`),
  CONSTRAINT `vessel_FK` FOREIGN KEY (`vessel_id`) REFERENCES `vessel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `name` varchar(50) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `state_to_country_FK` (`country_id`),
  CONSTRAINT `state_to_country_FK` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `temporary` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `datewithtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `timezone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_code` varchar(20) DEFAULT NULL,
  `zone_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `staus` varchar(20) DEFAULT NULL,
  `email_id` varchar(25) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user__idx` (`id`),
  KEY `user_client_fk` (`client_id`),
  CONSTRAINT `user_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `vessel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vessel_no` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `flag_id` int(11) DEFAULT NULL,
  `lloyds _code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flag_country_FK` (`flag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;