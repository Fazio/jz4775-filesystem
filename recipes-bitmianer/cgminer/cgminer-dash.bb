DESCRIPTION = "Cgminer DASH miner SW"
LICENSE = "CLOSED"

DEPENDS = "ncurses curl"
SRCREV = "${AUTOREV}"
SRCREV_machine = "${AUTOREV}"
PR = "r1"
SRC_URI = "git://git@gitlab.bitmain.com/antminer/cgminer-dash.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

CFLAGS_prepend = "-g -I ${B} -I ${B}/compat/jansson-2.6/src -I ${B}/compat/libusb-1.0/libusb -I ${S} -I ${S}/compat/jansson-2.6/src -I ${S}/compat/libusb-1.0/libusb"
#CFLAGS = "-ggdb -pipe -feliminate-unused-debug-types -I ${S}/compat/jansson-2.6/src -I ${S}/compat/libusb-1.0/libusb"

EXTRA_OECONF = " \
	     --enable-bitmain-D1 \
	     --disable-adl \
	     --disable-opencl \
	     --disable-libcurl \
	     "

INHIBIT_PACKAGE_STRIP = "1"		 
do_configure_prepend() {
	echo ${BUILD_DATE} > ./build_date

}

do_compile_append() {
	cp ${S}/api-example.c ${B}
	${CC} ${CFLAGS} ${B}/api-example.c -o ${B}/api-example
}

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 ${B}/api-example ${D}${bindir}/cgminer-api
}
 
inherit autotools pkgconfig
