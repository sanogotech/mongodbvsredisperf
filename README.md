# mongodbvsredisperf

https://stackoverflow.com/questions/39813443/mongodb-vs-redis-performance-benchmarks-which-db-should-be-used-for-cache

https://www.tablesgenerator.com/markdown_tables

##  Tests

|        | Redis Read | Redis Write | Mongo Read | Mongo Write |
|--------|------------|-------------|------------|-------------|
| 1000   | 0          | 0           | 0          | 1           |
| 10000  | 0          | 0           | 0          | 1           |
| 100000 | 4          | 4           | 0          | 5           |
| 300000 |12          |13           | 0          | 12          |
| 500000 |20          |21           |1           | 18          |
