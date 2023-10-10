(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> (partition-by identity plain-text)
       (map (fn [run]
              (let [count (count run)
                    char (first run)]
                (if (= count 1)
                  (str char)
                  (str count char)))))
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> (re-seq #"(?:\d+\D|\D)" cipher-text)
       (map (fn [group]
              (if (re-matches #"\d+\D" group)
                (apply str (repeat (Integer/parseInt (re-find #"\d+" group)) (re-find #"\D" group)))
                group)))
       (apply str)))
