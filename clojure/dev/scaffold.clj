(ns scaffold
  (:require [clojure.java.io :as io]))

(defn day
  "clj -X:scaffold :year 2025 :day 1"
  [{:keys [year day]}]
  (let [d      (format "day%02d" day)
        ns-str (format "aoc.y%d.%s" year d)
        files  {(format "src/aoc/y%d/%s.clj" year d)
                (format "(ns %s\n  (:require [aoc.util :as u]))\n\n(defn parse [input])\n(defn part1 [parsed])\n(defn part2 [parsed])\n\n(comment\n  (def ex (parse (u/example %d %d)))\n  (part1 ex))\n"
                        ns-str year day)

                (format "test/aoc/y%d/%s_test.clj" year d)
                (format "(ns %s-test\n  (:require [clojure.test :refer [deftest is]]\n            [aoc.util :as u]\n            [%s :as d]))\n\n(deftest example\n  (is (= nil (d/part1 (d/parse (u/example %d %d))))))\n"
                        ns-str ns-str year day)

                (format "inputs/%d/%s.txt" year d) ""
                (format "inputs/%d/%s-example.txt" year d) ""}]
    (doseq [[path content] files]
      (when-not (.exists (io/file path))   ; never overwrite your work
        (io/make-parents path)
        (spit path content)))))
