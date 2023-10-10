(ns word-count)
  (:require [clojure.string :as str])

(defn word-count [s]
  (->> (str/lower-case s)
       (str/replace #"[^\w']+" " ")
       (str/split #"\s+")
       (remove str/blank?)
       (frequencies)))
