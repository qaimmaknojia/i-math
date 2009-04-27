var reply0 = function(data) {
	if (data != null && typeof data == 'object')
		alert(dwr.util.toDescriptiveString(data, 2));
	else
		dwr.util.setValue('d0', dwr.util.toDescriptiveString(data, 1));
}
