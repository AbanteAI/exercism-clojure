(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (count (filter #(= nucleotide %) strand)))

(defn nucleotide-counts [strand]
(defn nucleotide-counts [strand]
  (if (re-matches #"^[ACGT]*$" strand)
    (let [nucleotides [\A \C \G \T]]
      (into {} (map (fn [nucleotide] [nucleotide (count-of-nucleotide-in-strand nucleotide strand)]) nucleotides)))
    (throw (IllegalArgumentException. "Invalid DNA sequence"))))
    (throw (IllegalArgumentException. "Invalid DNA sequence"))))
