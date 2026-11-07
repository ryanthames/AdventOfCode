(ns aoc.y2025.day01-test
  (:require [clojure.test :refer [deftest is]]
            [aoc.util :as u]
            [aoc.y2025.day01 :as d]))

(deftest example
  (is (= nil (d/part1 (d/parse (u/example 2025 1))))))
