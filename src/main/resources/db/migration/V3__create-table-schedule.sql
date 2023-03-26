CREATE TABLE schedules (
  id BIGINT AUTO_INCREMENT NOT NULL,
   patient_id BIGINT NULL,
   doctor_id BIGINT NULL,
   schedule_date datetime NULL,
   status VARCHAR(255) NULL,
   CONSTRAINT pk_schedules PRIMARY KEY (id)
);

ALTER TABLE schedules ADD CONSTRAINT FK_SCHEDULES_ON_DOCTOR FOREIGN KEY (doctor_id) REFERENCES doctors (id);

ALTER TABLE schedules ADD CONSTRAINT FK_SCHEDULES_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patients (id);