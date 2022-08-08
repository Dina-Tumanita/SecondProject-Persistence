CREATE TABLESPACE dsu_data
   DATAFILE '/opt/oracle/oradata/orcl/XEPDB1/dsu_data_01.dbf' SIZE 100M
   AUTOEXTEND ON NEXT 10M MAXSIZE 1024M;

CREATE TABLESPACE dsu_index
   DATAFILE '/opt/oracle/oradata/orcl/XEPDB1/dsu_index_01.dbf' SIZE 100M
   AUTOEXTEND ON NEXT 10M MAXSIZE 1024M;

alter session set "_ORACLE_SCRIPT"=true;

CREATE USER dsu 
IDENTIFIED BY dsu_123
DEFAULT TABLESPACE dsu_data
TEMPORARY TABLESPACE temp;

grant connect, resource, dba to dsu;
grant unlimited tablespace to dsu;

