(ns gigasecond)

(defn from [year month day]
  (let [gigasecond 1000000000
        date (java.time.LocalDateTime/of year month day 0 0)
        gigasecond-date (-> date
                            (.toInstant (java.time.ZoneOffset/UTC))
                            (.plusSeconds gigasecond)
                            (.atZone (java.time.ZoneId/systemDefault))
                            (.toLocalDateTime))]
    gigasecond-date))
