(defproject test-neanderthal "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [uncomplicate/neanderthal "0.18.0"]]
 

  :main ^:skip-aot test-neanderthal.core
  :plugins [[lein-with-env-vars "0.1.0"]]
  :env-vars {:DYLD_LIBRARY_PATH "resources/lib:resources/mkl/lib"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
