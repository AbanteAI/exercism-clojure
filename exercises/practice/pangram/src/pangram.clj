(ns pangram)

(defn pangram? [sentence]
  (let [letters (map char (range (int \a) (inc (int \z))))
        lower-sentence (clojure.string/lower-case sentence)]
    (every? #(not= (clojure.string/index-of lower-sentence %) -1) letters)))
    (every? #(clojure.string/includes? lower-sentence %) letters)))
