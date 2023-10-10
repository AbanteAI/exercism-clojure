(ns sieve)

(defn sieve [n]
  (let [sieve-range (vec (repeat (+ n 1) true))
        sqrt-n (int (Math/sqrt n))]
    (doseq [i (range 2 (+ sqrt-n 1))]
      (when (sieve-range i)
        (doseq [j (range (* i i) (+ n 1) i)]
          (aset sieve-range j false))))
    (filterv #(sieve-range %) (range 2 (+ n 1))))
