-- URL: https://leetcode.com/problems/rising-temperature/

SELECT
    w1.Id AS 'Id'
FROM weather w1
JOIN weather w2 ON DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
        AND w1.Temperature > w2.Temperature;