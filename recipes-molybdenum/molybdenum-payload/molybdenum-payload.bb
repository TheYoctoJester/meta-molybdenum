SUMMARY = "Package up molybdenum-inner"
HOMEPAGE = "http://theyoctojester.info"

LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "${PN}"

INHIBIT_DEFAULT_DEPS = "1"

# Variables to control where images are found: the multiconfig name, and the deploy dir.
CONTAINER_PACKAGE_MC ?= "molybdenum-inner"

CONTAINER_PACKAGE_DEPLOY_DIR = "${TOPDIR}/tmp-inner/deploy/images/qemuarm"

do_install[mcdepends] += "multiconfig::molybdenum-inner:molybdenum-image-inner:do_image_complete"

do_install () {
	install ${CONTAINER_PACKAGE_DEPLOY_DIR}/molybdenum-inner-image-payload.tar.bz2 ${D}/molybdenum-inner-image-payload.tar.bz2
}

FILES_${PN} = "/molybdenum-inner-image-payload.tar.bz2"

# we don't need those!
do_configure[noexec] = "1"
do_compile[noexec] = "1"
deltask do_populate_sysroot
