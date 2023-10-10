(ns atbash-cipher)

(defn encode [plaintext]
  (let [plain "abcdefghijklmnopqrstuvwxyz"
        cipher (apply str (reverse plain))
        trans (zipmap plain cipher)]
    (->> plaintext
         (map #(Character/toLowerCase %))
         (filter #(Character/isLetterOrDigit %))
         (map #(get trans % %))
         (partition 5)
         (map #(apply str %))
         (interpose " ")
         (apply str))))

(defn decode [ciphertext]
  (let [plain "abcdefghijklmnopqrstuvwxyz"
        cipher (apply str (reverse plain))
        trans (zipmap cipher plain)]
    (->> ciphertext
         (filter #(Character/isLetterOrDigit %))
         (map #(% trans))
         (apply str))))
