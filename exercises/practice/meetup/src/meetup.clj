(ns meetup)
(:require [clojure.string :as str]
          [clojure.tools.logging :as log])
(import 'java.time.LocalDate
        'java.time.DayOfWeek)

(defn day-of-week [year month day]
  (.getValue (DayOfWeek/from (.of LocalDate year month day))))
(defn nth-day-of-week [year month day-of-week n]
  (let [start-date (.of LocalDate year month 1)
        start-day (.getValue (DayOfWeek/from start-date))
        day-delta (if (< start-day day-of-week)
                    (- day-of-week start-day)
                    (- (+ 7 day-of-week) start-day))]
    (.plusDays start-date (+ day-delta (* 7 (dec n))))))
  (let [day-of-week-map {"mon" 1 "tues" 2 "wednes" 3 "thurs" 4 "fri" 5 "satur" 6 "sun" 7}
(defn teenth-day-of-week [year month day-of-week]
  (nth-day-of-week year month day-of-week 2))

(defn meetup [year month descriptor]
  (let [day-of-week-map {"mon" 1 "tues" 2 "wednes" 3 "thurs" 4 "fri" 5 "satur" 6 "sun" 7}
        descriptor-parts (str/split descriptor #" ")
        day-of-week (day-of-week-map (first descriptor-parts))
        descriptor-type (second descriptor-parts)]
    (cond
      (= descriptor-type "teenth") (teenth-day-of-week year month day-of-week)
      (= descriptor-type "last") (nth-day-of-week year month day-of-week 5)
      :else (nth-day-of-week year month day-of-week (Integer/parseInt descriptor-type)))))