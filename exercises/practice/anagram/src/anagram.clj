(ns anagram)
(:require [clojure.string :as string])

(defn anagrams-for [word prospect-list]
  (let [sorted-word (sort (string/lower-case word))]
    (filter (fn [candidate]
              (let [lower-candidate (string/lower-case candidate)
                    sorted-candidate (sort lower-candidate)]
                (and (= sorted-word sorted-candidate)
                     (not= lower-candidate (string/lower-case word)))))
            prospect-list)))
