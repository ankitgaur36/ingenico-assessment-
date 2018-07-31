  CREATE TABLE account (
  id          INTEGER IDENTITY PRIMARY KEY,
  username     VARCHAR(64) NOT NULL,
  balance      INTEGER, 
  currencycode   VARCHAR(15) NOT NULL);
  
  
  
  
  CREATE TABLE transaction (
  transaction_id          INTEGER IDENTITY PRIMARY KEY,
  currencycode     VARCHAR(64) NOT NULL,
  amount      INTEGER, 
  transfereeaccountid   VARCHAR(15) NOT NULL,
  beneficiaryaccountid   VARCHAR(15) NOT NULL);
  