/*INSERT EVENTS */
INSERT INTO `events` VALUES (1,'Evento 1','desc evento1','2014-02-01 00:00:00','2014-02-01 00:00:00','1',20,30,30,1),(2,'Evento2','desc evento2','2014-02-01 00:00:00','2014-02-01 00:00:00','1',30,40,40,2),(3,'Evento3','desc evento3','2014-02-01 00:00:00','2014-02-01 00:00:00','1',24,24,24,3),(4,'Evento4','desc evento4','2014-02-01 00:00:00','2014-02-01 00:00:00','1',4,66,66,4),(5,'Evento5','desc evento5','2014-02-01 00:00:00','2014-02-01 00:00:00','1',3,22,22,5),(6,'Evento6','desc evento6','2014-02-01 00:00:00','2014-02-01 00:00:00','1',2,22,22,6),(7,'Evento7','desc evento7','2014-02-01 00:00:00','2014-02-01 00:00:00','1',33,99,99,7),(8,'Evento8','desc evento8','2014-02-01 00:00:00','2014-02-01 00:00:00','1',1,98,98,8),(9,'Evento9','desc evento9','2014-02-01 00:00:00','2014-02-01 00:00:00','1',11,11,11,1),(10,'Evento10','desc evento10','2014-02-01 00:00:00','2014-02-01 00:00:00','1',111,111,111,9),(11,'Evento11','desc evento11','2014-02-01 00:00:00','2014-02-01 00:00:00','1',1,11,11,3),(12,'Evento12','desc evento12','2014-02-01 00:00:00','2014-02-01 00:00:00','1',2,2,2,4),(13,'Evento13','desc evento13','2014-02-01 00:00:00','2014-02-01 00:00:00','1',44,44,44,5),(14,'Evento14','desc evento14','2014-02-01 00:00:00','2014-02-01 00:00:00','1',877,88,88,6),(15,'Evento15','desc evento15','2014-02-01 00:00:00','2014-02-01 00:00:00','1',33,33,33,7),(16,'Evento 16','desc evento16','2014-02-01 00:00:00','2014-02-01 00:00:00','1',11,11,11,8);

/*INSERT EVENT_USERS */
INSERT INTO `events_users` VALUES (1,1,2),(2,2,2),(3,3,2),(4,4,2),(5,5,2),(6,6,2),(7,7,2),(8,8,2),(9,9,2),(10,10,2),(11,11,2),(12,12,2),(13,13,2),(14,14,2),(15,15,2),(16,16,2),(17,1,3);

/*INSERT LARGE BUSINESS */

INSERT INTO `large_business` VALUES (1);

/*INSERT MUSEUM */
INSERT INTO `museum` VALUES (2);

/*INSERT PARK */
INSERT INTO `park` VALUES (3);

/*INSERT PLACES */
INSERT INTO `places` VALUES (1,1,'Large business1',100,'desc large business1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,1),(2,2,'museum1',100,'desc museum1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,1),(3,3,'park1',100,'desc park1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(4,4,'stadium1',100,'desc stadium1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(5,5,'theater1',100,'desc theater1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(6,6,'touristic attraction1',100,'desc touristic attraction1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(7,7,'traditional market1',100,'desc trad market1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(8,8,'zoo1',100,'desc zoo1','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0),(9,2,'museum2',100,'desc museum2','2014-02-01 00:00:00','2014-02-01 00:00:00','SOUTH',NULL,0);

/*INSERT STADIUM */
INSERT INTO `stadium` VALUES (4);

/*INSERT THEATER */
INSERT INTO `theater` VALUES (5);

/*INSERT TOURIST ATTRACTION */
INSERT INTO `tourist_attraction` VALUES (6);

/*INSERT TRADITIONAL MARKET */
INSERT INTO `traditional_market` VALUES (7);

/*INSERT USERS */
INSERT INTO `users` VALUES (1,'admin1','password1','admin user1','lastname user1','73118304Q','usuario1@dominio.com','666666666','addressuser1',1),(2,'user2','passowrd2','user2 name','lastname user2','77777777Q','usuario2@dominio.com','666888888','address user2',0),(3,'user3','password3','user3name','lastname user3','88888888Q','usario3@dominio.com','666666666','address user3',0);

/*INSERT ZOO */
INSERT INTO `zoo` VALUES (8);
