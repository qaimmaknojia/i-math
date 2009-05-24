//userService
if (dwr == null)
	var dwr = {};
if (dwr.engine == null)
	dwr.engine = {};
if (DWREngine == null)
	var DWREngine = dwr.engine;

if (userService == null)
	var userService = {};
userService._path = '/dwr';
userService.verify = function(p0, p1, callback) {
	dwr.engine._execute(userService._path, 'userService', 'verify', p0, p1,
			callback);
}
userService.currentUser = function(callback) {
	dwr.engine._execute(userService._path, 'userService', 'currentUser',
			callback);
}
userService.getUserDao = function(callback) {
	dwr.engine._execute(userService._path, 'userService', 'getUserDao',
			callback);
}
userService.setUserDao = function(p0, callback) {
	dwr.engine._execute(userService._path, 'userService', 'setUserDao', p0,
			callback);
}

//gadgetRenderService
// Provide a default path to dwr.engine
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (gadgetRenderService == null) var gadgetRenderService = {};
gadgetRenderService._path = '/dwr';
gadgetRenderService.getContainer = function(callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'getContainer', callback);
}
gadgetRenderService.getGadgetDao = function(callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'getGadgetDao', callback);
}
gadgetRenderService.setGadgetDao = function(p0, callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'setGadgetDao', p0, callback);
}
gadgetRenderService.renderGadget = function(p0, p1, callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'renderGadget', p0, p1, callback);
}
gadgetRenderService.getMainContainerDao = function(callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'getMainContainerDao', callback);
}
gadgetRenderService.setMainContainerDao = function(p0, callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'setMainContainerDao', p0, callback);
}
gadgetRenderService.setContainerService = function(p0, callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'setContainerService', p0, callback);
}
gadgetRenderService.getContainerService = function(callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'getContainerService', callback);
}
gadgetRenderService.getAllGadgets = function(callback) {
  dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService', 'getAllGadgets', callback);
}

