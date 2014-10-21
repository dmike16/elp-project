FILE(REMOVE_RECURSE
  "Mirror.pdb"
  "Mirror"
)

# Per-language clean rules from dependency scanning.
FOREACH(lang)
  INCLUDE(CMakeFiles/Mirror.dir/cmake_clean_${lang}.cmake OPTIONAL)
ENDFOREACH(lang)
