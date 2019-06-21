CREATE TABLE c_plan.equipment_type__c (api_name varchar(255) PRIMARY KEY, value varchar(255));
-- Insert data in 'equipment_type__c' table actual for 21.06.2019
INSERT INTO c_plan.equipment_type__c (value, api_name) VALUES
('Autowalk', '001'),
('Building', '000'),
('Building Door', '002'),
('Dumbwaiter', '003'),
('Elevator', '004'),
('Escalator', '005'),
('Façadator', '007'),
('Marine Elevator', '010'),
('Marine Escalator', '011'),
('Marine Other Eq.', '012'),
('Other', '999'),
('PFI', '008'),
('Stairlift', '006'),
('Test', 'Test');

CREATE SCHEMA IF NOT EXISTS c_plan;

-- Views creation
CREATE OR REPLACE VIEW c_plan.view_asset AS
  SELECT ass.id, ass.sfid, ass.name, ass.equipment_type__c, eq.value AS "equipment_type_value",
  ass.customer_asset_name__c, ass.equipment_phone_number__c, acc.id AS "account_id", acc.name AS "account_name",
  acc.sales_organizations__c, sold_to.id AS "sold_to_id", sold_to.name AS "sold_to_name", loc.id AS "location_id",
  loc.name AS "location_name", ass.installation_street__c, ass.installation_city__c, ass.installation_state_provice__c,
  ass.installation_country__c, st.id AS "service_territory_id", st.name AS "service_territory_name",
  wc.id AS "work_center_id", wc.name AS "work_center_name", ass.fsm_last_valid_cli_end_date__c
  FROM salesforce.asset ass
  LEFT JOIN c_plan.equipment_type__c eq ON ass.equipment_type__c = eq.api_name
  LEFT JOIN salesforce.account acc ON ass.accountid = acc.sfid
  LEFT JOIN salesforce.account sold_to ON ass.sold_to_sfdc_id__c = sold_to.sfid
  LEFT JOIN salesforce.location loc ON ass.locationid = loc.sfid
  LEFT JOIN salesforce.serviceterritory st ON ass.maintenance_planner_group__c = st.sfid
  LEFT JOIN salesforce.work_center__c wc ON ass.main_work_center__c = wc.sfid;

CREATE OR REPLACE VIEW c_plan.view_callout AS
  SELECT concat_ws('_', c.id, coalesce(wo.id, -1), coalesce(sa.id, -1)) AS "composite_key", c.id, c.sfid,
  c.casenumber, c.createddate, c.entrapment__c, c.hazard__c, c.injury__c, c.street__c, c.city__c, c.state_province__c,
  c.recordtypeid, c.caller_name__c, c.caller_phone_number__c, c.contactphone, c.status, c.fsm_contact_is_passenger__c,
  c.caseownertxt__c, c.description, ass.id AS "asset_id", ass.name AS "asset_name", loc.name AS "location_name",
  con.name AS "contact_name", wo.id AS "workorder_id", wo.workordernumber AS "workorder_number", wo.assembly__c,
  wo.maintenance_activity_type_code__c, wo.due_date__c, sa.id AS "serviceappointment_id", sa.appointmentnumber,
  sa.status AS "serviceappointment_status", sr.id AS "serviceresource_id", sr.name AS "serviceresource_name",
  st.id AS "serviceterritory_id", st.name AS "serviceterritory_name", acc.id AS "account_id", acc.name AS "account_name",
  acc.sales_organizations__c
  FROM salesforce.case c
  LEFT JOIN salesforce.asset ass ON c.assetid = ass.sfid
  LEFT JOIN salesforce.location loc ON ass.locationid = loc.sfid
  LEFT JOIN salesforce.contact con ON c.contactid = con.sfid
  LEFT JOIN salesforce.workorder wo ON wo.caseid = c.sfid
  LEFT JOIN salesforce.serviceappointment sa ON sa.work_order__c = wo.sfid
  LEFT JOIN salesforce.serviceresource sr ON sa.assigned_service_resource__c = sr.sfid
  LEFT JOIN salesforce.serviceterritory st ON sa.serviceterritoryid = st.sfid
  LEFT JOIN salesforce.account acc ON c.accountid = acc.sfid;

CREATE OR REPLACE VIEW c_plan.view_case_details AS
  SELECT c.id, c.sfid, c.subject, c.casenumber, c.status, c.caseownertxt__c, c.createddate, c.recordtypeid,
  c.entrapment__c, c.hazard__c, c.injury__c, c.contactphone, c.caller_name__c, c.caller_phone_number__c,
  c.fsm_contact_is_passenger__c, c.description, ass.id AS "asset_id", ass.name AS "asset_name", con.name AS "contact_name",
  acc.id AS "account_id", acc.name AS "account_name", acc.sales_organizations__c
  FROM salesforce.case c
  LEFT JOIN salesforce.asset ass ON c.assetid = ass.sfid
  LEFT JOIN salesforce.contact con ON c.contactid = con.sfid
  LEFT JOIN salesforce.account acc ON c.accountid = acc.sfid;

CREATE OR REPLACE VIEW c_plan.view_entitlement AS
  SELECT e.id, e.sfid, e.assetid, e.name, e.coverage__c, e.startdate, e.enddate, e.status, e.response_time__c,
  e.response_time_after_hours__c, oh.name AS "callout_hours__c", oh2.name AS "service_hours__c"
  FROM salesforce.entitlement e
  LEFT JOIN salesforce.operatinghours oh ON e.callout_hours__c = oh.sfid
  LEFT JOIN salesforce.operatinghours oh2 ON e.service_hours__c = oh.sfid;

CREATE OR REPLACE VIEW c_plan.view_fsm_wc_assignment_of_resource AS
  SELECT wc.id, wc.name, wca.service_resource__c
  FROM salesforce.fsm_work_center_assignment__c wca
  LEFT JOIN salesforce.work_center__c wc ON wc.sfid = wca.work_center__c;

CREATE OR REPLACE VIEW c_plan.view_fsm_wc_assignment_of_work_center AS
  SELECT wca.id, wca.work_center__c, wca.preference_type__c, wca.start_date__c, wca.end_date__c, wc.id AS "workcenter_id",
  wc.name AS "workcenter_name", sr.id AS "service_resource_id", sr.name AS "service_resource_name", wt.name AS "work_type_name"
  FROM salesforce.fsm_work_center_assignment__c wca
  LEFT JOIN salesforce.serviceresource sr ON wca.service_resource__c = sr.sfid
  LEFT JOIN salesforce.worktype wt ON wt.sfid = wca.work_type__c
  LEFT JOIN salesforce.work_center__c wc ON wc.sfid = wca.work_center__c;

CREATE OR REPLACE VIEW c_plan.view_resourceabsence AS
  SELECT * FROM salesforce.resourceabsence;

CREATE OR REPLACE VIEW c_plan.view_serviceappointment AS
  SELECT sa.id, sa.sfid, sa.appointmentnumber, sa.work_order__c, sa.status, sa.scheduled_start_original__c,
  sa.scheduled_end_original__c, sr.id AS "serviceresource_id", sr.name AS "serviceresource_name", u.sales_organization__c
  FROM salesforce.serviceappointment sa
  LEFT JOIN salesforce.serviceresource sr ON sa.assigned_service_resource__c = sr.sfid
  LEFT JOIN salesforce.user u ON sa.ownerid = u.sfid;

CREATE OR REPLACE VIEW c_plan.view_serviceappointment_details AS
  SELECT sa.id, sa.sfid, sa.appointmentnumber, sa.status, sa.lastmodifieddate, sa.scheduled_start_original__c,
  sa.scheduled_end_original__c, sa.fsl__pinned__c, sa.blocked_reason__c, acc.id AS "account_id", acc.name AS "account_name",
  sr.id AS "serviceresource_id", sr.name AS "serviceresource_name", wo.id AS "workorder_id", wo.workordernumber AS "workorder_number",
  ass.id AS "asset_id", ass.name AS "asset_name", st.id AS "serviceterritory_id", st.name AS "serviceterritory_name",
  u.sales_organization__c
  FROM salesforce.serviceappointment sa
  LEFT JOIN salesforce.account acc ON sa.accountid = acc.sfid
  LEFT JOIN salesforce.serviceresource sr ON sa.assigned_service_resource__c = sr.sfid
  LEFT JOIN salesforce.workorder wo ON sa.work_order__c = wo.sfid
  LEFT JOIN salesforce.asset ass ON wo.assetid = ass.sfid
  LEFT JOIN salesforce.serviceterritory st ON wo.serviceterritoryid = st.sfid
  LEFT JOIN salesforce.user u ON sa.ownerid = u.sfid;

CREATE OR REPLACE VIEW c_plan.view_serviceappointment_of_resource AS
  SELECT sa.id, sa.sfid, sa.appointmentnumber, sa.status, sa.scheduled_start_original__c, sa.scheduled_end_original__c,
  sa.fsl__pinned__c, sa.assigned_service_resource__c, wo.id AS "workorder_id", wo.workordernumber AS "workorder_number",
  wo.earliest_start_date__c, wo.due_date__c, wo.maintenance_activity_type__c, wo.assembly__c, wo.description__c,
  loc.name AS "location_name", ass.installation_street__c, ass.installation_city__c
  FROM salesforce.serviceappointment sa
  LEFT JOIN salesforce.workorder wo ON sa.work_order__c = wo.sfid
  LEFT JOIN salesforce.asset ass ON wo.assetid = ass.sfid
  LEFT JOIN salesforce.location loc ON wo.locationid = loc.sfid;

CREATE OR REPLACE VIEW c_plan.view_serviceresource AS
  SELECT sr.id, sr.sfid, sr.name, sr.phone__c, sr.isactive, u.sales_organization__c
  FROM salesforce.serviceresource sr
  LEFT JOIN salesforce.user u ON sr.relatedrecordid = u.sfid;

CREATE OR REPLACE VIEW c_plan.view_serviceterritory AS
  SELECT st.id, st.sfid, st.name, u.sales_organization__c
  FROM salesforce.serviceterritory st
  LEFT JOIN salesforce.user u ON st.ownerid = u.sfid;

CREATE OR REPLACE VIEW c_plan.view_serviceterritorymember_of_resource AS
  SELECT st.id, st.name, stm.territorytype, stm.shift_type__c, stm.effectivestartdate, stm.effectiveenddate,
  stm.serviceresourceid
  FROM salesforce.serviceterritorymember stm
  LEFT JOIN salesforce.serviceterritory st ON stm.serviceterritoryid = st.sfid;

CREATE OR REPLACE VIEW c_plan.view_serviceterritorymember_of_territory AS
  SELECT stm.id, stm.serviceterritoryid, stm.effectivestartdate, stm.effectiveenddate, sr.id AS "service_resource_id",
  sr.name AS "service_resource_name", sr.phone__c, sr.isactive
  FROM salesforce.serviceterritorymember stm
  LEFT JOIN salesforce.serviceresource sr ON stm.serviceresourceid = sr.sfid;

CREATE OR REPLACE VIEW c_plan.view_user AS
  SELECT u.id, u.sfid, u.profileid, u.name, u.email, u.federationidentifier, u.sales_organization__c,
  u.languagelocalekey, u.localesidkey, u.timezonesidkey, u.userroleid, p.name AS "profile_name"
  FROM salesforce."user" u
  LEFT JOIN salesforce.profile p ON u.profileid = p.sfid;

CREATE OR REPLACE VIEW c_plan.view_work_center__c AS
  SELECT * FROM salesforce.work_center__c;

CREATE OR REPLACE VIEW c_plan.view_workorder AS
  SELECT wo.id, wo.sfid, wo.workOrderNumber, wo.status, wo.earliest_start_date__c, wo.due_date__c, wo.caseid,
  u.sales_organization__c
  FROM salesforce.workorder wo
  LEFT JOIN salesforce."user" u ON wo.ownerid = u.sfid;

CREATE OR REPLACE VIEW c_plan.view_workorder_details AS
  SELECT wo.id, wo.sfid, wo.workordernumber, wo.status, wo.lastmodifieddate, wo.earliest_start_date__c,
  wo.due_date__c, wo.maintenance_activity_type_code__c, wo.assembly__c, wo.description__c, acc.id AS "account_id",
  acc.name AS "account_name", ass.id AS "asset_id", ass.name AS "asset_name", st.id AS "serviceterritory_id",
  st.name AS "serviceterritory_name", loc.name AS "location_name", c.id AS "case_id", c.casenumber, u.sales_organization__c
  FROM salesforce.workorder wo
  LEFT JOIN salesforce.account acc ON wo.accountid = acc.sfid
  LEFT JOIN salesforce.asset ass ON wo.assetid = ass.sfid
  LEFT JOIN salesforce.serviceterritory st ON wo.serviceterritoryid = st.sfid
  LEFT JOIN salesforce.location loc ON wo.locationid = loc.sfid
  LEFT JOIN salesforce.case c ON wo.caseid = c.sfid
  LEFT JOIN salesforce.user u ON wo.ownerid = u.sfid;