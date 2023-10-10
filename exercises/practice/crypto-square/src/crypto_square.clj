(ns crypto-square)

(defn normalize-plaintext [text]
  (clojure.string/replace (clojure.string/lower-case text) #"[^a-z0-9]" ""))

(defn square-size [text]
  (let [len (count text)]
    (if (zero? len) 0 (int (Math/ceil (Math/sqrt len))))))
(defn plaintext-segments [text]
  (let [c (square-size text)
        padded-text (apply str (concat text (repeat (- (* c (int (Math/ceil (/ (count text) c)))) (count text)) " ")))]
    (partition c c padded-text)))
(defn ciphertext [text]
  (apply str (mapcat #(apply str %) (apply map vector (plaintext-segments (normalize-plaintext text))))))
(defn normalize-ciphertext [text]
  (let [c (square-size (normalize-plaintext text))]
    (clojure.string/join " " (map #(apply str %) (partition c c (ciphertext text))))))