(ns rna-transcription)

(defn to-rna [dna]
  (apply str (map dna-to-rna dna)))
    \G \C
    \C \G
    \T \A
    \A \U))
  (apply str (map dna-to-rna dna))
