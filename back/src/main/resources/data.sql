INSERT INTO PRODUCT_ENTITY (TITLE, AIRED_YEAR, BROADCAST_AT, GENRE, RANK, RATING)
SELECT * FROM CSVREAD('C:/Prj/spring/alpca-alone/data/top100_kdrama.csv');