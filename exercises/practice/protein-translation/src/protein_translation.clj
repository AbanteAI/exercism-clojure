(ns protein-translation)

(defn translate-codon [codon]
  (case codon
    "AUG" "Methionine"
    "UUU" "Phenylalanine"
    "UUC" "Phenylalanine"
    "UUA" "Leucine"
    "UUG" "Leucine"
    "UCU" "Serine"
    "UCC" "Serine"
    "UCA" "Serine"
    "UCG" "Serine"
    "UAU" "Tyrosine"
    "UAC" "Tyrosine"
    "UGU" "Cysteine"
    "UGC" "Cysteine"
    "UGG" "Tryptophan"
    "UAA" "STOP"
    "UAG" "STOP"
    "UGA" "STOP"))

(defn translate-rna [rna]
  (let [codons (re-seq #"\w{3}" rna)
        proteins (map translate-codon codons)]
    (take-while #(not= % "STOP") proteins)))
