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
if (dwr == null)
	var dwr = {};
if (dwr.engine == null)
	dwr.engine = {};
if (DWREngine == null)
	var DWREngine = dwr.engine;

if (gadgetRenderService == null)
	var gadgetRenderService = {};
gadgetRenderService._path = '/dwr';
gadgetRenderService.getContainer = function(callback) {
	dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService',
			'getContainer', callback);
}
gadgetRenderService.renderGadget = function(p0, p1, callback) {
	dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService',
			'renderGadget', p0, p1, callback);
}
gadgetRenderService.getMainContainerDao = function(callback) {
	dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService',
			'getMainContainerDao', callback);
}
gadgetRenderService.setMainContainerDao = function(p0, callback) {
	dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService',
			'setMainContainerDao', p0, callback);
}
gadgetRenderService.setContainerService = function(p0, callback) {
	dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService',
			'setContainerService', p0, callback);
}
gadgetRenderService.getContainerService = function(callback) {
	dwr.engine._execute(gadgetRenderService._path, 'gadgetRenderService',
			'getContainerService', callback);
}

//containerService
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (containerService == null) var containerService = {};
containerService._path = '/dwr';
containerService.getUserService = function(callback) {
  dwr.engine._execute(containerService._path, 'containerService', 'getUserService', callback);
}
containerService.getMainContainerDao = function(callback) {
  dwr.engine._execute(containerService._path, 'containerService', 'getMainContainerDao', callback);
}
containerService.setMainContainerDao = function(p0, callback) {
  dwr.engine._execute(containerService._path, 'containerService', 'setMainContainerDao', p0, callback);
}
containerService.getMainContainer = function(callback) {
  dwr.engine._execute(containerService._path, 'containerService', 'getMainContainer', callback);
}
containerService.setUserService = function(p0, callback) {
  dwr.engine._execute(containerService._path, 'containerService', 'setUserService', p0, callback);
}
