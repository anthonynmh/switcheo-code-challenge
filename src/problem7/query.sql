SELECT wallet_table.address
FROM (
    SELECT b.address,
        SUM(
        CASE
            WHEN b.denom = 'usdc' THEN 0.000001 * b.amount
            WHEN b.denom = 'swth' THEN 0.00000005 * b.amount
            WHEN b.denom = 'tmz' THEN 0.003 * b.amount
        END)
        AS wallet_amount
    FROM balances b
    GROUP BY b.address) wallet_table 
INNER JOIN trades t 
    ON wallet_table.address = t.address
WHERE t.block_height > 730000;




/*
CREATE TABLE balances (
    id int,
    address text,
    denom text,
    amount bigint,
    block_height int
);

INSERT INTO balances 
VALUES (1, '0xabab', 'usdc', 50000000000000, 733755);

INSERT INTO balances 
VALUES (2, '0x99cc', 'swth', -20000000, 733757);

INSERT INTO balances 
VALUES (3, '0xabab', 'usdc', -50000000000, 733855);

CREATE TABLE trades (
    id int,
    address text,
    denom text,
    amount bigint,
    block_height int
);

INSERT INTO trades 
VALUES (1, '0xabab', 'swth', 400000000000, 733756);

INSERT INTO trades 
VALUES (2, '0x99cc', 'usdc', 3500000000000, 733757);

INSERT INTO trades 
VALUES (3, '0x67f3', 'swth', 72000000000000, 733758);
*/
