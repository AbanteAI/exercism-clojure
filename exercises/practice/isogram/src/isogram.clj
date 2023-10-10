(ns isogram
  (:require [clojure.string :as str]))

(defn isogram? [s]
  (let [normalized (->> s
                        (clojure.string/lower-case)
                        (filter #(contains? (set "abcdefghijklmnopqrstuvwxyz") %)))]
    (= (count normalized) (count (distinct normalized))))
