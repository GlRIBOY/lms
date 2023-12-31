--------------------------------------------------------
--  颇老捞 积己凳 - 格夸老-8岿-31-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table NOTICE
--------------------------------------------------------

  CREATE TABLE "GIRI"."NOTICE" 
   (	"NOTICE_ID" NUMBER, 
	"NOTICE_WRITER" VARCHAR2(50 BYTE), 
	"NOTICE_TITLE" VARCHAR2(200 BYTE), 
	"NOTICE_SUBJECT" VARCHAR2(400 BYTE), 
	"NOTICE_DATE" DATE DEFAULT sysdate, 
	"NOTICE_ATTECH" VARCHAR2(512 BYTE), 
	"NOTICE_ATTECH_DIR" VARCHAR2(512 BYTE), 
	"NOTICE_HIT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into GIRI.NOTICE
SET DEFINE OFF;
Insert into GIRI.NOTICE (NOTICE_ID,NOTICE_WRITER,NOTICE_TITLE,NOTICE_SUBJECT,NOTICE_DATE,NOTICE_ATTECH,NOTICE_ATTECH_DIR,NOTICE_HIT) values (1,'rrrrr','rrrr','rrrrr',to_date('23/08/31','RR/MM/DD'),null,null,null);
--------------------------------------------------------
--  Constraints for Table NOTICE
--------------------------------------------------------

  ALTER TABLE "GIRI"."NOTICE" MODIFY ("NOTICE_ID" NOT NULL ENABLE);
  ALTER TABLE "GIRI"."NOTICE" MODIFY ("NOTICE_WRITER" NOT NULL ENABLE);
  ALTER TABLE "GIRI"."NOTICE" MODIFY ("NOTICE_TITLE" NOT NULL ENABLE);
