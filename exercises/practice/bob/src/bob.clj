(ns bob)

(defn response-for [s]
  (let [trimmed-s (clojure.string/trim s)]
    (cond
      (and (re-find #"\?$" trimmed-s) (not (re-find #"[a-z]" trimmed-s)) (re-find #"[A-Z]" trimmed-s)) "Calm down, I know what I'm doing!"
      (re-find #"\?$" trimmed-s) "Sure."
      (and (not (re-find #"[a-z]" trimmed-s)) (re-find #"[A-Z]" trimmed-s)) "Whoa, chill out!"
      (clojure.string/blank? trimmed-s) "Fine. Be that way!"
      :else "Whatever.")))
