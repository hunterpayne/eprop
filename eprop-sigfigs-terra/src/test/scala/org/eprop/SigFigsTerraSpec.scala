
package org.eprop

import org.scalatest.{ FlatSpec, Matchers }
import org.eprop.EKey._
import org.eprop.EKeySigFigsTerra._

import org.sigfigs._
import org.sigfigs.terra._
import electro._
import energy.{ WattsPerCubicMeter => EWattsPerCubicMeter, _ }
import information._
import market._
import mass._
import motion._
import photo._
import radio._
import space._
import thermal._
import time._

trait SigFigsFixture {

  object DimensionlessPType extends EKeyType[Dimensionless]('dimensionless)

  object ElectricCurrentPType 
      extends EKeyType[ElectricCurrent]('electricCurrent)
  object CapacitancePType extends EKeyType[Capacitance]('capacitance)
  object ConductivityPType extends EKeyType[Conductivity]('conductivity)
  object ElectricChargePType extends EKeyType[ElectricCharge]('electricCharge)
  object ElectricPotentialPType 
      extends EKeyType[ElectricPotential]('electricPotential)
  object ElectricalConductancePType 
      extends EKeyType[ElectricalConductance]('electricalConductance)
  object ElectricalResistancePType 
      extends EKeyType[ElectricalResistance]('electricalResistance)
  object InductancePType extends EKeyType[Inductance]('inductance)
  object MagneticFluxPType extends EKeyType[MagneticFlux]('magneticFlux)
  object MagneticFluxDensityPType 
      extends EKeyType[MagneticFluxDensity]('magneticFluxDensity)
  object ResistivityPType extends EKeyType[Resistivity]('resistivity)

  object EnergyPType extends EKeyType[Energy]('energy)
  object PowerDensityPType extends EKeyType[PowerDensity]('powerDensity)
  object EnergyDensityPType extends EKeyType[EnergyDensity]('energyDensity)
  object EnergyAreaDensityPType 
      extends EKeyType[EnergyAreaDensity]('energyAreaDensity)
  object PowerPType extends EKeyType[Power]('power)
  object PowerRampPType extends EKeyType[PowerRamp]('powerRamp)
  object SpecificEnergyPType extends EKeyType[SpecificEnergy]('specificEnergy)
  object MolarEnergyPType extends EKeyType[MolarEnergy]('molarEnergy)

  object DataRatePType extends EKeyType[DataRate]('dataRate)
  object InformationPType extends EKeyType[Information]('information)

  object MoneyPType extends EKeyType[Money]('money)
  object EmployeePType extends EKeyType[Employee]('employee)
  object LaborPType extends EKeyType[Labor]('labor)

  object AreaDensityPType extends EKeyType[AreaDensity]('areaDensity)
  object DensityPType extends EKeyType[Density]('density)
  object MassPType extends EKeyType[Mass]('mass)
  object ChemicalAmountPType extends EKeyType[ChemicalAmount]('chemicalAmount)
  object MolarMassPType extends EKeyType[MolarMass]('molarMass)
  object MolarityPType extends EKeyType[Molarity]('molarity)
  object ConcentrationPType extends EKeyType[Concentration]('concentration)
  object CatalyticActivityPType 
      extends EKeyType[CatalyticActivity]('catalyticActivity)

  object AccelerationPType extends EKeyType[Acceleration]('acceleration)
  object AngularAccelerationPType 
      extends EKeyType[AngularAcceleration]('angularAcceleration)
  object AngularVelocityPType 
      extends EKeyType[AngularVelocity]('angularVelocity)
  object ForcePType extends EKeyType[Force]('force)
  object JerkPType extends EKeyType[Jerk]('jerk)
  object MassFlowPType extends EKeyType[MassFlow]('massFlow)
  object MomentumPType extends EKeyType[Momentum]('momentum)
  object PressureChangePType extends EKeyType[PressureChange]('pressureChange)
  object PressurePType extends EKeyType[Pressure]('pressure)
  object VelocityPType extends EKeyType[Velocity]('velocity)
  object VolumeFlowPType extends EKeyType[VolumeFlow]('volumeFlow)
  object YankPType extends EKeyType[Yank]('yank)
  object SurfaceTensionPType extends EKeyType[SurfaceTension]('surfaceTension)
  object ViscosityPType extends EKeyType[Viscosity]('viscosity)

  object IlluminancePType extends EKeyType[Illuminance]('illuminance)
  object LuminancePType extends EKeyType[Luminance]('luminance)
  object LuminousEnergyPType extends EKeyType[LuminousEnergy]('luminousEnergy)
  object LuminousExposurePType 
      extends EKeyType[LuminousExposure]('luminousExposure)
  object LuminousFluxPType extends EKeyType[LuminousFlux]('luminousFlux)
  object LuminousIntensityPType 
      extends EKeyType[LuminousIntensity]('luminousIntensity)

  object IrradiancePType extends EKeyType[Irradiance]('irradiance)
  object RadiancePType extends EKeyType[Radiance]('radiance)
  object SpectralIntensityPType 
      extends EKeyType[SpectralIntensity]('spectralIntensity)
  object SpectralIrradiancePType 
      extends EKeyType[SpectralIrradiance]('spectralIrradiance)
  object SpectralPowerPType extends EKeyType[SpectralPower]('spectralPower)
  object ActivityPType extends EKeyType[Activity]('activity)
  object ParticleFluxPType extends EKeyType[ParticleFlux]('particleFlux)
  object DosePType extends EKeyType[Dose]('dose)
  object AreaTimePType extends EKeyType[AreaTime]('areaTime)
  object AbsorbedDosePType extends EKeyType[AbsorbedDose]('absorbedDose)

  object AnglePType extends EKeyType[Angle]('angle)
  object LengthPType extends EKeyType[Length]('length)
  object AreaPType extends EKeyType[Area]('area)
  object VolumePType extends EKeyType[Volume]('volume)
  object SolidAnglePType extends EKeyType[SolidAngle]('solidAngle)
  object SpecificVolumePType extends EKeyType[SpecificVolume]('specificVolume)
  object MolarVolumePType extends EKeyType[MolarVolume]('molarVolume)

  object TemperaturePType extends EKeyType[Temperature]('temperature)
  object ThermalCapacityPType 
      extends EKeyType[ThermalCapacity]('thermalCapacity)

  object TimePType extends EKeyType[Time]('time)
  object FrequencyPType extends EKeyType[Frequency]('frequency)
  object TimeSquaredPType extends EKeyType[TimeSquared]('timeSquared)

  // declare your extensible model type
  class Container(props: EProperty[_]*) extends Extensible {

    merge(Seq(Kilograms(10) as MassPType)) // a default
    merge(props)

    def dimensionless: Option[Dimensionless] = 
      get[Dimensionless](DimensionlessPType)

    def electricCurrent: Option[ElectricCurrent] = 
      get[ElectricCurrent](ElectricCurrentPType)
    def capacitance: Option[Capacitance] = get[Capacitance](CapacitancePType)
    def conductivity: Option[Conductivity] = 
      get[Conductivity](ConductivityPType)
    def electricCharge: Option[ElectricCharge] = 
      get[ElectricCharge](ElectricChargePType)
    def electricPotential: Option[ElectricPotential] = 
      get[ElectricPotential](ElectricPotentialPType)
    def electricalConductance: Option[ElectricalConductance] = 
      get[ElectricalConductance](ElectricalConductancePType)
    def electricalResistance: Option[ElectricalResistance] = 
      get[ElectricalResistance](ElectricalResistancePType)
    def inductance: Option[Inductance] = get[Inductance](InductancePType)
    def magneticFlux: Option[MagneticFlux] = 
      get[MagneticFlux](MagneticFluxPType)
    def magneticFluxDensity: Option[MagneticFluxDensity] = 
      get[MagneticFluxDensity](MagneticFluxDensityPType)
    def resistivity: Option[Resistivity] = get[Resistivity](ResistivityPType)

    def energy: Option[Energy] = get[Energy](EnergyPType)
    def powerDensity: Option[PowerDensity] = 
      get[PowerDensity](PowerDensityPType)
    def energyDensity: Option[EnergyDensity] = 
      get[EnergyDensity](EnergyDensityPType)
    def energyAreaDensity: Option[EnergyAreaDensity] = 
      get[EnergyAreaDensity](EnergyAreaDensityPType)
    def power: Option[Power] = get[Power](PowerPType)
    def powerRamp: Option[PowerRamp] = get[PowerRamp](PowerRampPType)
    def specificEnergy: Option[SpecificEnergy] = 
      get[SpecificEnergy](SpecificEnergyPType)
    def molarEnergy: Option[MolarEnergy] = get[MolarEnergy](MolarEnergyPType)

    def dataRate: Option[DataRate] = get[DataRate](DataRatePType)
    def information: Option[Information] = get[Information](InformationPType)

    def money: Option[Money] = get[Money](MoneyPType)
    def employee: Option[Employee] = get[Employee](EmployeePType)
    def labor: Option[Labor] = get[Labor](LaborPType)

    def areaDensity: Option[AreaDensity] = get[AreaDensity](AreaDensityPType)
    def density: Option[Density] = get[Density](DensityPType)
    def mass: Option[Mass] = get[Mass](MassPType)
    def chemicalAmount: Option[ChemicalAmount] = 
      get[ChemicalAmount](ChemicalAmountPType)
    def molarMass: Option[MolarMass] = get[MolarMass](MolarMassPType)
    def molarity: Option[Molarity] = get[Molarity](MolarityPType)
    def concentration: Option[Concentration] = 
      get[Concentration](ConcentrationPType)
    def catalyticActivity: Option[CatalyticActivity] = 
      get[CatalyticActivity](CatalyticActivityPType)

    def acceleration: Option[Acceleration] = 
      get[Acceleration](AccelerationPType)
    def angularAcceleration: Option[AngularAcceleration] = 
      get[AngularAcceleration](AngularAccelerationPType)
    def angularVelocity: Option[AngularVelocity] = 
      get[AngularVelocity](AngularVelocityPType)
    def force: Option[Force] = get[Force](ForcePType)
    def jerk: Option[Jerk] = get[Jerk](JerkPType)
    def massFlow: Option[MassFlow] = get[MassFlow](MassFlowPType)
    def momentum: Option[Momentum] = get[Momentum](MomentumPType)
    def pressureChange: Option[PressureChange] = 
      get[PressureChange](PressureChangePType)
    def pressure: Option[Pressure] = get[Pressure](PressurePType)
    def velocity: Option[Velocity] = get[Velocity](VelocityPType)
    def volumeFlow: Option[VolumeFlow] = get[VolumeFlow](VolumeFlowPType)
    def yank: Option[Yank] = get[Yank](YankPType)
    def surfaceTension: Option[SurfaceTension] = 
      get[SurfaceTension](SurfaceTensionPType)
    def viscosity: Option[Viscosity] = get[Viscosity](ViscosityPType)

    def illuminance: Option[Illuminance] = get[Illuminance](IlluminancePType)
    def luminance: Option[Luminance] = get[Luminance](LuminancePType)
    def luminousEnergy: Option[LuminousEnergy] = 
      get[LuminousEnergy](LuminousEnergyPType)
    def luminousExposure: Option[LuminousExposure] = 
      get[LuminousExposure](LuminousExposurePType)
    def luminousFlux: Option[LuminousFlux] = 
      get[LuminousFlux](LuminousFluxPType)
    def luminousIntensity: Option[LuminousIntensity] = 
      get[LuminousIntensity](LuminousIntensityPType)

    def irradiance: Option[Irradiance] = get[Irradiance](IrradiancePType)
    def radiance: Option[Radiance] = get[Radiance](RadiancePType)
    def spectralIntensity: Option[SpectralIntensity] = 
      get[SpectralIntensity](SpectralIntensityPType)
    def spectralIrradiance: Option[SpectralIrradiance] = 
      get[SpectralIrradiance](SpectralIrradiancePType)
    def spectralPower: Option[SpectralPower] = 
      get[SpectralPower](SpectralPowerPType)
    def activity: Option[Activity] = get[Activity](ActivityPType)
    def particleFlux: Option[ParticleFlux] = 
      get[ParticleFlux](ParticleFluxPType)
    def dose: Option[Dose] = get[Dose](DosePType)
    def areaTime: Option[AreaTime] = get[AreaTime](AreaTimePType)
    def absorbedDose: Option[AbsorbedDose] = 
      get[AbsorbedDose](AbsorbedDosePType)

    def angle: Option[Angle] = get[Angle](AnglePType)
    def length: Option[Length] = get[Length](LengthPType)
    def area: Option[Area] = get[Area](AreaPType)
    def volume: Option[Volume] = get[Volume](VolumePType)
    def solidAngle: Option[SolidAngle] = get[SolidAngle](SolidAnglePType)
    def specificVolume: Option[SpecificVolume] = 
      get[SpecificVolume](SpecificVolumePType)
    def molarVolume: Option[MolarVolume] = get[MolarVolume](MolarVolumePType)

    def temperature: Option[Temperature] = get[Temperature](TemperaturePType)
    def thermalCapacity: Option[ThermalCapacity] = 
      get[ThermalCapacity](ThermalCapacityPType)

    def time: Option[Time] = get[Time](TimePType)
    def frequency: Option[Frequency] = get[Frequency](FrequencyPType)
    def timeSquared: Option[TimeSquared] = get[TimeSquared](TimeSquaredPType)
  }

  // now make an instance of your container with some values
  val container = new Container(
    Grams(10) as MassPType, Meters(10.0) as LengthPType, 
    SquareMeters(15.2) as AreaPType)

  val container2 = new Container(
    Percent(50.0) as DimensionlessPType,

    Amperes(0.1) as ElectricCurrentPType,
    Farads(7) as CapacitancePType,
    SiemensPerMeter(6) as ConductivityPType,
    Coulombs(5) as ElectricChargePType,
    Volts(4) as ElectricPotentialPType,
    Siemens(3) as ElectricalConductancePType,
    Ohms(2000) as ElectricalResistancePType,
    Henry(15) as InductancePType,
    Webers(14) as MagneticFluxPType,
    Teslas(13) as MagneticFluxDensityPType,
    OhmMeters(12) as ResistivityPType,

    Joules(11) as EnergyPType,
    EWattsPerCubicMeter(10) as PowerDensityPType,
    JoulesPerCubicMeter(9) as EnergyDensityPType,
    JoulesPerSquareMeter(9) as EnergyAreaDensityPType,
    Watts(8) as PowerPType,
    WattsPerHour(7) as PowerRampPType,
    JoulesPerKilogram(6) as SpecificEnergyPType,
    JoulesPerMole(5) as MolarEnergyPType,

    BytesPerSecond(7000000) as DataRatePType,
    Bytes(100000) as InformationPType,

    USD(1000000) as MoneyPType,
    People(10) as EmployeePType,
    PersonHours(200000) as LaborPType,

    GramsPerSquareCentimeter(5) as AreaDensityPType,
    KilogramsPerCubicMeter(4) as DensityPType,
    Kilograms(3) as MassPType,
    Moles(2) as ChemicalAmountPType,
    KilogramsPerMole(71) as MolarMassPType,
    MolesPerKilogram(71) as MolarityPType,
    MolesPerCubicMeter(72) as ConcentrationPType,
    Katals(73) as CatalyticActivityPType,

    MetersPerSecondSquared(35) as AccelerationPType,
    DegreesPerSecondSquared(34) as AngularAccelerationPType,
    RadiansPerSecond(34) as AngularVelocityPType,
    Newtons(33) as ForcePType,
    MetersPerSecondCubed(32) as JerkPType,
    KilogramsPerSecond(31) as MassFlowPType,
    NewtonSeconds(30) as MomentumPType,
    PascalsPerSecond(29) as PressureChangePType,
    Bars(28) as PressurePType,
    KilometersPerHour(27) as VelocityPType,
    CubicMetersPerSecond(26) as VolumeFlowPType,
    NewtonsPerSecond(25) as YankPType,
    NewtonsPerMeter(25) as SurfaceTensionPType,
    PascalSeconds(25) as ViscosityPType,

    Lux(24) as IlluminancePType,
    CandelasPerSquareMeter(23) as LuminancePType,
    LumenSeconds(22) as LuminousEnergyPType,
    LuxSeconds(21) as LuminousExposurePType,
    Lumens(20) as LuminousFluxPType,
    Candelas(19) as LuminousIntensityPType,

    ErgsPerSecondPerSquareCentimeter(18) as IrradiancePType,
    WattsPerSteradianPerSquareMeter(17) as RadiancePType,
    WattsPerSteradianPerMeter(16) as SpectralIntensityPType,
    ErgsPerSecondPerSquareCentimeterPerAngstrom(9) as SpectralIrradiancePType,
    WattsPerMeter(15) as SpectralPowerPType,
    Becquerels(21) as ActivityPType,
    BecquerelsPerSquareMeterSecond(22) as ParticleFluxPType,
    Sieverts(23) as DosePType,
    SquareMeterSeconds(24) as AreaTimePType,
    Grays(25) as AbsorbedDosePType,

    Degrees(14) as AnglePType,
    Meters(13) as LengthPType,
    SquareMeters(12) as AreaPType,
    CubicMeters(11) as VolumePType,
    SquareRadians(10) as SolidAnglePType,
    CubicMetersPerKilogram(11) as SpecificVolumePType,
    CubicMetersPerMole(11) as MolarVolumePType,

    Kelvin(273.15) as TemperaturePType,
    JoulesPerKelvin(8) as ThermalCapacityPType,

    Seconds(7) as TimePType,
    Hertz(6) as FrequencyPType,
    SecondsSquared(SDD(5)) as TimeSquaredPType
  )
}

class SigFigsTerraSpec extends FlatSpec with Matchers with SigFigsFixture {

  "The properties" should "read squants types correctly" in {
    
    container.mass should be(Some(Kilograms(0.01)))
    container.length should be(Some(Meters(10.0)))
    container.area should be(Some(SquareMeters(15.2)))

    container2.dimensionless.get * container2.dimensionless.get should be(
      Percent(SDD(25, 1)))

    container2.electricCurrent.get should be(Milliamperes(100))
    container2.capacitance.get should be(Farads(7))
    container2.conductivity.get should be(SiemensPerMeter(6))
    container2.electricCharge.get should be(Coulombs(5))
    container2.electricPotential.get should be(Volts(4))
    container2.electricalConductance.get should be(Siemens(3))
    container2.electricalResistance.get should be(Kilohms(2))
    container2.inductance.get should be(Henry(15))
    container2.magneticFlux.get should be(Webers(14))
    container2.magneticFluxDensity.get should be(Teslas(13))
    container2.resistivity.get should be(OhmMeters(12))

    container2.energy.get should be(Joules(11))
    
    container2.powerDensity.get should be(EWattsPerCubicMeter(10))
    container2.energyDensity.get should be(JoulesPerCubicMeter(9))
    container2.energyAreaDensity.get should be(JoulesPerSquareMeter(9))
    container2.power.get should be(Watts(8))
    container2.powerRamp.get should be(WattsPerHour(7))
    container2.specificEnergy.get should be(JoulesPerKilogram(6))
    container2.molarEnergy.get should be(JoulesPerMole(5))

    container2.dataRate.get should be(BytesPerSecond(7000000))
    container2.information.get should be(Bytes(100000))

    container2.money.get should be(USD(1000000))
    container2.employee.get should be(People(10))
    container2.labor.get should be(PersonHours(200000))

    container2.areaDensity.get should be(GramsPerSquareCentimeter(5))
    container2.density.get should be(KilogramsPerCubicMeter(4))
    container2.mass.get should be(Grams(3000))
    container2.chemicalAmount.get should be(Moles(2))
    container2.molarMass.get should be(KilogramsPerMole(71))
    container2.molarity.get should be(MolesPerKilogram(71))
    container2.concentration.get should be(MolesPerCubicMeter(72))
    container2.catalyticActivity.get should be(Katals(73))

    container2.acceleration.get should be(MetersPerSecondSquared(35))
    container2.angularAcceleration.get should be(DegreesPerSecondSquared(34))
    container2.angularVelocity.get should be(RadiansPerSecond(34))
    container2.force.get should be(Newtons(33))
    container2.jerk.get should be(MetersPerSecondCubed(32))
    container2.massFlow.get should be(KilogramsPerSecond(31))
    container2.momentum.get should be(NewtonSeconds(30))
    container2.pressureChange.get should be(PascalsPerSecond(29))
    container2.pressure.get should be(Bars(28))
    container2.velocity.get should be(KilometersPerHour(27))
    container2.volumeFlow.get should be(CubicMetersPerSecond(26))
    container2.yank.get should be(NewtonsPerSecond(25))
    container2.surfaceTension.get should be(NewtonsPerMeter(25))
    container2.viscosity.get should be(PascalSeconds(25))

    container2.illuminance.get should be(Lux(24))
    container2.luminance.get should be(CandelasPerSquareMeter(23))
    container2.luminousEnergy.get should be(LumenSeconds(22))
    container2.luminousExposure.get should be(LuxSeconds(21))
    container2.luminousFlux.get should be(Lumens(20))
    container2.luminousIntensity.get should be(Candelas(19))

    container2.irradiance.get should be(ErgsPerSecondPerSquareCentimeter(18))
    container2.radiance.get should be(WattsPerSteradianPerSquareMeter(17))
    container2.spectralIntensity.get should be(WattsPerSteradianPerMeter(16))
    
    container2.spectralIrradiance.get should be(
      ErgsPerSecondPerSquareCentimeterPerAngstrom(9))
    container2.spectralPower.get should be(WattsPerMeter(15))
    container2.activity.get should be(Becquerels(21))
    container2.particleFlux.get should be(BecquerelsPerSquareMeterSecond(22))
    container2.dose.get should be(Sieverts(23))
    container2.areaTime.get should be(SquareMeterSeconds(24))
    container2.absorbedDose.get should be(Grays(25))

    container2.angle.get should be(Degrees(14))
    container2.length.get should be(Meters(13))
    container2.area.get should be(SquareMeters(12))
    container2.volume.get should be(CubicMeters(11))
    container2.solidAngle.get should be(SquareRadians(10))
    container2.specificVolume.get should be(CubicMetersPerKilogram(11))
    container2.molarVolume.get should be(CubicMetersPerMole(11))

    container2.temperature.get should be(Celsius(0.0))
    container2.thermalCapacity.get should be(JoulesPerKelvin(8))

    container2.time.get should be(Seconds(7))
    container2.frequency.get should be(Hertz(6))
    container2.timeSquared.get should be(SecondsSquared(SDD(5)))
  }
}
