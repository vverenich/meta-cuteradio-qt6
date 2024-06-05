SUMMARY = "CuteRadio - Simple Internet radio for showing QML and Qt on embedded systems"
AUTHOR = "VIARENICH ULADZISLAU"
HOMEPAGE = "https://github.com/vverenich/cuteradio-apps"

SECTION = "app"

LICENSE = "MIT"
LIC_FILES_CHKSUM="file://LICENSE;md5=1ef68d7e526c164e11da8965fdbed52c"

inherit cmake update-rc.d

SRC_URI = "\
    git://github.com/vverenich/cuteradio-apps.git;branch=master;protocol=https \
    file://cuteradio \
"
SRCREV = "25c1511566325b93a2b7c7e4ed519dbd143b2845"

PV = "1.0+git${SRCREV}"

DEPENDS = "qtmultimedia"

INITSCRIPT_NAME = "cuteradio"
INITSCRIPT_PARAMS = "defaults 70"

S = "${WORKDIR}/git"

do_install:append() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/cuteradio ${D}${sysconfdir}/init.d/cuteradio
}


FILES_${PN} += "/usr/local/bin/${PN}"
