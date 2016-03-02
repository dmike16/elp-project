#!/bin/sh


mvn -B archetype:generate -DarchetypeGroupId=$1 -DarchetypeArtifactId=$2 -DgroupId=$3  -DartifactId=$4
