--------------------------------------------------------
--  ������ ������ - �����-8��-31-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REPLY
--------------------------------------------------------

  CREATE TABLE "GIRI"."REPLY" 
   (	"REPLY_ID" NUMBER, 
	"NOTICE_ID" NUMBER, 
	"REPLY" VARCHAR2(300 BYTE), 
	"REPLYER" VARCHAR2(200 BYTE), 
	"REPLY_DATE" DATE DEFAULT sysdate
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into GIRI.REPLY
SET DEFINE OFF;
Insert into GIRI.REPLY (REPLY_ID,NOTICE_ID,REPLY,REPLYER,REPLY_DATE) values (9,1,'ȣ�������','�Ͽ���',to_date('23/08/31','RR/MM/DD'));
Insert into GIRI.REPLY (REPLY_ID,NOTICE_ID,REPLY,REPLYER,REPLY_DATE) values (8,1,'�϶˱���','user1',to_date('23/08/31','RR/MM/DD'));
Insert into GIRI.REPLY (REPLY_ID,NOTICE_ID,REPLY,REPLYER,REPLY_DATE) values (10,2,'testasdfsffsfs','admin',to_date('23/08/31','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index PK_REPLY
--------------------------------------------------------

  CREATE UNIQUE INDEX "GIRI"."PK_REPLY" ON "GIRI"."REPLY" ("REPLY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table REPLY
--------------------------------------------------------

  ALTER TABLE "GIRI"."REPLY" MODIFY ("NOTICE_ID" NOT NULL ENABLE);
  ALTER TABLE "GIRI"."REPLY" MODIFY ("REPLY" NOT NULL ENABLE);
  ALTER TABLE "GIRI"."REPLY" MODIFY ("REPLYER" NOT NULL ENABLE);
  ALTER TABLE "GIRI"."REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY ("REPLY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;