{{/*
Expand the name of the chart.
*/}}
{{- define "jwt-login.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create a default fully qualified app name.
*/}}
{{- define "jwt-login.fullname" -}}
{{- default .Chart.Name .Values.fullnameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create the name of the service account to use
*/}}
{{- define "jwt-login.serviceAccountName" -}}
{{- if .Values.serviceAccount.create }}
{{- default (include "jwt-login.fullname" .) .Values.serviceAccount.name }}
{{- else }}
{{- default "default" .Values.serviceAccount.name }}
{{- end }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "jwt-login.labels" -}}
helm.sh/chart: {{ include "jwt-login.chart" . }}
{{ include "jwt-login.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "jwt-login.selectorLabels" -}}
app.kubernetes.io/name: {{ include "jwt-login.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "jwt-login.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Infrastructure service names
*/}}
{{- define "jwt-login.postgresql.fullname" -}}
{{- .Values.postgresql.fullname }}
{{- end }}
