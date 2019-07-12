DROP TABLE IF EXISTS vote;
 
CREATE TABLE vote (
  id INT AUTO_INCREMENT PRIMARY KEY,
  item INT NOT NULL,
  user VARCHAR(5) NOT NULL,
  business_unit VARCHAR(3) NOT NULL,
  time_of_voting TIMESTAMP NOT NULL
);

INSERT INTO VOTE (id, item, user, business_unit, time_of_voting)
VALUES
  (-1, 10, '0001', 'IXA', '2019-07-12 08:27'),
  (-2,  8,  '0002', 'IXF', '2019-07-12 08:27'),
  (-3,  3,  '0003', 'IXI', '2019-07-12 08:27'),
  (-4,  5,  '0004', 'IXP', '2019-07-12 08:27'),
  (-5,  3,  '0005', 'IXQ', '2019-07-12 08:27'),
  (-6,  4,  '0006', 'IXS', '2019-07-12 08:27'),
  (-7,  2,  '0007', 'IXI', '2019-07-12 08:27'),
  (-8, 10,  '0007', 'IXI', '2019-06-12 08:27')
;
