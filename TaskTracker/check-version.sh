version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout=true)


convert_to_num() {
	echo $(($1))
}

get_version() {
	echo $(mvn help:evaluate -Dexpression=project.version -q -DforceStdout=true)
}

new_major() {
	if [[ $version == *"-SNAPSHOT"* ]]; then
		echo "project version is a SNAPSHOT";
		mvn versions:set -DnewVersion=1.0.0;
		echo "project version updated to 1.0.0"
	else
		IFS=. read -r -a mmp <<< "$version"
		major=$(convert_to_num ${mmp[0]})
		minor=$(convert_to_num ${mmp[1]})
		patch=$(convert_to_num ${mmp[2]})
		new_version="$((major + 1)).$minor.$patch"
		echo "$new_version"
		mvn versions:set -DnewVersion=$new_version
	fi
}

if [[ $1 == "major" ]]; then
	new_major
elif [[ $1 == "showVersion" ]]; then
	get_version
else
	echo "invalid arg"
fi