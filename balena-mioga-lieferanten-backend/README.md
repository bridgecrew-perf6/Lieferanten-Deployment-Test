# balena-mioga-lieferanten-backend
balena-mioga-lieferanten-backend - Functions:





Ports: 8080


## Backend functions:
- transfer product data files (csv, xslx, txt, xml, odt, zip, rar ... ) from various delivery-sources (sqlite3 db) over different mediums (ftp, sftp, scp, http, https, Rest-API, SOAP) with or without username/password
- logs every action to InfluxDB
- extract archives
- read product data files line-by-line
- execute a call to different gearman functions (save2db_mongo, save2db_coudb, save2db_sql, call2url, save2file) with every line of data
- send a status after last line 

## Frontend functions:
WebUI for Create, Read, Update, Delete (CRUD) entries: 

    ### delivery-sources with:
    - title(255),Description(TEXT), UUID, tags(?), updated_at(TIME), checked_at(TIME)

     #### delivery-source-contacts with:
     - title, description, uuid, tags, anrede, name, vorname, firmenname, telefonnr festnetz company, telefonnr pers. ansprechpartner, email ansprechpartner, companylogo, updated_at

     #### delivery-sources-auth with:
     - title, uuid, typeOF_auth, Array of [login_username, login_userpassword], updated_at, successlogin_at

     #### delivery-sources-timetables:
     - title, uuid, desc

--- 
???

   ### distributedworkingclasshelper-actions:
   - actiontitle, description(helptext), command2execute(?)
 
 
 ---
 STEPS TO RUN
 
 -> JAVA executable
 -> Maven
 
 .\mvnw install:help
 
