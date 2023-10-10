(ns allergies)

(defn allergies [score]
  (let [allergens {:eggs 1, :peanuts 2, :shellfish 4, :strawberries 8, :tomatoes 16, :chocolate 32, :pollen 64, :cats 128}]
    (mapv first (filter (fn [[k v]] (not= (bit-and score v) 0)) allergens))))

(defn allergic-to? [score allergen]
  (let [allergens {:eggs 1, :peanuts 2, :shellfish 4, :strawberries 8, :tomatoes 16, :chocolate 32, :pollen 64, :cats 128}]
    (not= (bit-and score (get allergens allergen)) 0)))
