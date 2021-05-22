(ns ui.prosemirror.theme
  (:require
   [re-frame.core :refer [subscribe]]
   [taoensso.timbre :as timbre :refer [debug info warn error]]))

(def themes
  ["default" "3024-day" "3024-night" "abcdef" "ambiance" "ayu-dark" "ayu-mirage"
   "base16-dark" "base16-light" "bespin" "blackboard" "cobalt" "colorforth"
   "darcula" "dracula" "duotone-dark" "duotone-light" "eclipse" "elegant"
   "erlang-dark" "gruvbox-dark" "hopscotch" "icecoder" "idea" "isotope"
   "lesser-dark" "liquibyte" "lucario" "material" "material-darker"
   "material-palenight" "material-ocean" "mbo" "mdn-like" "midnight" "monokai"
   "moxer" "neat" "neo" "night" "nord" "oceanic-next" "panda-syntax"
   "paraiso-dark" "paraiso-light" "pastel-on-dark" "railscasts" "rubyblue"
   "seti" "shadowfox" "solarized dark" "solarized light" "the-matrix"
   "tomorrow-night-bright" "tomorrow-night-eighties" "ttcn" "twilight"
   "vibrant-ink" "xq-dark" "xq-light" "yeti" "yonce" "zenburn"])

;(def themes (->> theme-names (mapv vector (map keyword theme-names)) (into {})))



