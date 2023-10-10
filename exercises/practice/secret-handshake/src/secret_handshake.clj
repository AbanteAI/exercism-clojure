(ns secret-handshake)

(defn commands [number]
  (let [binary (apply str (reverse (take 5 (concat (map #(if (= % 1) "1" "0") (reverse (Integer/toBinaryString number))) (repeat "0")))))
        actions (keep (fn [digit action] (when (= digit \1) action)) binary ["wink" "double blink" "close your eyes" "jump"])]
    (if (= (first binary) \1) (reverse actions) actions)))
